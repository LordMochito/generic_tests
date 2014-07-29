package com.codetest.acceptance.tests;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.codetest.pojos.CatalogItem;
import com.codetest.pojos.CatalogSet;
import com.codetest.repositories.SupermarketCatalogRepository;
import com.codetest.repositories.SupermarketCatalogSetRepository;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class BackgroundBootstrap {
	
	@Inject
	private SupermarketCatalogRepository supermarketCatalogRepository;
	
	@Inject
	private SupermarketCatalogSetRepository supermarketCatalogSetRepository;

	@Given("^a set of this stored goods:$")
	public void a_set_of_this_stored_goods(DataTable table) throws Throwable {
		clearItAll();
		List<Map<String, String>> asMaps = table.asMaps();
		for (Map<String, String> dataRow : asMaps) {
			CatalogItem catalogRow = map2Catalog(dataRow);
			supermarketCatalogRepository.save(catalogRow);
		}
	}

	private CatalogItem map2Catalog(Map<String, String> dataRow) {
		CatalogItem catalogRow = new CatalogItem();
		CatalogSet catalogSet = null;//supermarketCatalogSetRepository.findByName(dataRow.get("Item_set"));
		//if (catalogSet == null){
			catalogSet = new CatalogSet();
			catalogSet.setName(dataRow.get("Item_set"));
		//}
		catalogRow.setArticleSet(catalogSet);
		catalogRow.setName(dataRow.get("Item_name"));
		catalogRow.setDescription(dataRow.get("Item_name"));
		catalogRow.setPrice(Double.valueOf(dataRow.get("Price")));
		return catalogRow;
	}
	private void clearItAll() {
		//supermarketCatalogSetRepository.deleteAll();
		//supermarketCatalogRepository.deleteAll();
	}
}
