package fr.treeptik.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@ManagedBean(name = "employeMB")
public class EmployeManagedBean {

	@Inject
	private FacesContext facesContext;

	@Inject
	private EmployeService employeService;

	private Employe employe;

	private ListDataModel<Employe> employes = new ListDataModel<>();

	private List<SelectItem> selectEmploye = new ArrayList<>();

	@PostConstruct
	public void init() {
		setEmploye(new Employe());
	}

	public String register() throws Exception {
		try {
			employeService.register(getEmploye());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
		return "list";
	}

	public void remove() throws Exception {
		try {
			employe = employes.getRowData();
			employeService.removeById(employe.getId());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removed!",
					"Remove successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"Remove unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public ListDataModel<Employe> findAll() throws Exception {
		employes = new ListDataModel<>();

		try {
			employes.setWrappedData(employeService.findAll());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "FindAll!",
					"FindAll successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"FindAll unsuccessful");
			facesContext.addMessage(null, m);
		}

		return employes;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public ListDataModel<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(ListDataModel<Employe> employes) {
		this.employes = employes;
	}

	public List<SelectItem> getSelectEmploye() throws ServiceException {

		List<Employe> allEmploye = employeService.findAll();
		selectEmploye.clear();
		for (Employe employe : allEmploye) {

			selectEmploye.add(new SelectItem(employe.getId(), employe.getNom() + " - "
					+ employe.getPrenom()));
		}

		return selectEmploye;
	}

	public void setSelectEmploye(List<SelectItem> selectEmploye) {
		this.selectEmploye = selectEmploye;
	}

}
