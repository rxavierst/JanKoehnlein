package org.eclipse.xtext.graphview.editpart;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.GestureEvent;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.graphview.gestures.IViewerGestureListener;
import org.eclipse.xtext.graphview.instancemodel.AbstractInstance;
import org.eclipse.xtext.graphview.instancemodel.DiagramInstance;
import org.eclipse.xtext.graphview.view.GraphView;

import com.google.inject.Inject;

public class DrillingHelper {

	@Inject
	private GraphView graphView;

	public boolean drillUp(AbstractInstance model) {
		if (model.eContainer() != null) {
			System.out.println("drillup");
			DiagramInstance containerDiagram = EcoreUtil2.getContainerOfType(model.eContainer(), DiagramInstance.class);
			if (containerDiagram != null) {
				graphView.gotoDiagram(containerDiagram);
				return true;
			}
		}
		return false;
	}

	public boolean drillDown(AbstractInstance model) {
		for (AbstractInstance child : model.getChildren()) {
			if (child instanceof DiagramInstance && ((DiagramInstance) child).isOpenNewDiagram()) {
				graphView.gotoDiagram((DiagramInstance) child);
				return true;
			}
		}
		return false;
	}

	public DragTracker newDragTracker(IInstanceModelEditPart sourceEditPart, Request request) {
		return new DrillingDragTracker(sourceEditPart);
	}

	public class DrillingDragTracker extends DragEditPartsTracker implements IViewerGestureListener {

		public DrillingDragTracker(IInstanceModelEditPart sourceEditPart) {
			super(sourceEditPart);
		}

		public void gesture(GestureEvent gestureEvent, EditPartViewer viewer) {
			if (isInState(STATE_INITIAL)) {
				if (gestureEvent.detail == SWT.GESTURE_MAGNIFY) {
					if (gestureEvent.magnification > 1.)
						gestureEvent.doit = !drillDown((AbstractInstance) getSourceEditPart().getModel());
				}
			}
		}
	}
}