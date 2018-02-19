package org.olat.modules.curriculum.ui;

import org.olat.core.gui.UserRequest;
import org.olat.core.gui.components.Component;
import org.olat.core.gui.components.tabbedpane.TabbedPane;
import org.olat.core.gui.components.velocity.VelocityContainer;
import org.olat.core.gui.control.Event;
import org.olat.core.gui.control.WindowControl;
import org.olat.core.gui.control.controller.BasicController;
import org.olat.modules.curriculum.Curriculum;
import org.olat.modules.curriculum.CurriculumElement;

/**
 * 
 * Initial date: 16 févr. 2018<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
public class EditCurriculumElementOverviewController extends BasicController {
	
	private TabbedPane tabPane;
	
	private EditCurriculumElementController metadataCtrl;
	
	private Curriculum curriculum;
	private CurriculumElement element;
	
	public EditCurriculumElementOverviewController(UserRequest ureq, WindowControl wControl,
			CurriculumElement element, Curriculum curriculum) {
		super(ureq, wControl);
		this.curriculum = curriculum;
		this.element = element;
		
		VelocityContainer mainVC = createVelocityContainer("curriculum_element_overview");
		
		tabPane = new TabbedPane("tabs", getLocale());
		tabPane.addListener(this);
		
		metadataCtrl = new EditCurriculumElementController(ureq, getWindowControl(), element, curriculum);
		listenTo(metadataCtrl);
		tabPane.addTab(translate("curriculum.element.metadata"), metadataCtrl);
		initTabPane();
		
		mainVC.put("tabs", tabPane);
		
		putInitialPanel(mainVC);
	}
	
	private void initTabPane() {
		

		
	}

	@Override
	protected void doDispose() {
		//
	}

	@Override
	protected void event(UserRequest ureq, Component source, Event event) {
		//
	}
	
	

}
