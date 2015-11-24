package com.codetests.supermarket.checkout.acceptance.tests;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.codetests.supermarket.catalog.checkout.repositories.SupermarketCatalogRepository;
import com.codetests.supermarket.catalog.domain.CatalogItem;
import com.codetests.supermarket.catalog.domain.CatalogSet;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class BackgroundBootstrap {
	
	@Inject
	private SupermarketCatalogRepository supermarketCatalogRepository;
	
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
