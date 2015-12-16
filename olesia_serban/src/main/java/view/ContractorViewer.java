package view;

import java.util.List;

import data.Contractor;
import data.Product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContractorViewer {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;

	public ContractorViewer(int id, String name) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	//changes List into ObservableList
	public static ObservableList<ContractorViewer> 
	createListOfContractorsFromData(List<Contractor> list) {
		ObservableList<ContractorViewer> listObserve = FXCollections.observableArrayList();
		list.forEach(contr -> listObserve.add(new ContractorViewer(contr.getId()
				.intValue(), contr.getName())));
		return listObserve;

	}

}
