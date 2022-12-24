package com.itacademy.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.itacademy.ui.widgets.ResultPageWidget;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {
    protected final SelenideElement closeSearchResultButton = $(".search__close");
    protected final ElementsCollection searchTabsList = $$(".search__tabs");
    protected final SelenideElement itemTitle = $(".product__title");
    protected static ElementsCollection elementList = $$(By.xpath("//div[@class='result__item result__item_product']"));

    public SelenideElement getCloseSearchResultButton() {
        return closeSearchResultButton;
    }

    public ElementsCollection getSearchTabsList() {
        return searchTabsList;
    }

    //TODO: add proper waiter which resolves null pointer for List fill in

    public static List<ResultPageWidget> getResultItemList() {
        Selenide.sleep(5000);
        ElementsCollection.SelenideElementIterable selenideElements = elementList.asDynamicIterable();
        Stream<SelenideElement> stream = selenideElements.stream();
        List<SelenideElement> collect1 = stream.collect(Collectors.toList());
        List<ResultPageWidget> collect = collect1.stream()
                .map(element -> new ResultPageWidget(element))
                .collect(Collectors.toList());
        System.out.println();
        return collect;
    }
}