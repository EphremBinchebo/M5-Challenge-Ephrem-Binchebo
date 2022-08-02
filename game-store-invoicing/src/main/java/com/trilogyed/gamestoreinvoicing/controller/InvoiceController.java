package com.trilogyed.gamestoreinvoicing.controller;

import com.trilogyed.gamestoreinvoicing.model.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.model.GameViewModel;
import com.trilogyed.gamestoreinvoicing.model.TShirtViewModel;
import com.trilogyed.gamestoreinvoicing.service.GameStoreInvoicingServiceLayer;
import com.trilogyed.gamestoreinvoicing.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @Autowired
    private GameStoreCatalogClient client;
    @Autowired
    private GameStoreInvoicingServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel purchaseItem(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        invoiceViewModel = service.createInvoice(invoiceViewModel);
        return invoiceViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel findInvoice(@PathVariable("id") long invoiceId) {
        InvoiceViewModel invoiceViewModel = service.getInvoice(invoiceId);
        if (invoiceViewModel == null) {
            throw new IllegalArgumentException("Invoice could not be retrieved for id " + invoiceId);
        } else {
            return invoiceViewModel;
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> findAllInvoices() {
        List<InvoiceViewModel> invoiceViewModelList = service.getAllInvoices();

        if (invoiceViewModelList == null || invoiceViewModelList.isEmpty()) {
            throw new IllegalArgumentException("No invoices were found.");
        } else {
            return invoiceViewModelList;
        }
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> findInvoicesByCustomerName(@PathVariable String name) {
        List<InvoiceViewModel> invoiceViewModelList = service.getInvoicesByCustomerName(name);

        if (invoiceViewModelList == null || invoiceViewModelList.isEmpty()) {
            throw new IllegalArgumentException("No invoices were found for: " + name);
        } else {
            return invoiceViewModelList;
        }
    }

    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable long id) {
        return client.getConsole(id);
    }

    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameById(@PathVariable long id) {
        return service.getGame(id);
    }

    @GetMapping("tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable long id) {
        return service.getTShirt(id);
    }

    @PutMapping("/console")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        service.updateConsole(consoleViewModel);
    }

    @PutMapping("/game")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid GameViewModel gameViewModel) {
        service.updateGame(gameViewModel);
    }

    @PutMapping("/tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel) {
        service.updateTShirt(tShirtViewModel);
    }

}