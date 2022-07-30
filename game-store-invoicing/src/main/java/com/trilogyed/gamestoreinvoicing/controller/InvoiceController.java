package com.trilogyed.gamestoreinvoicing.controller;
//
//
//
//
//import com.trilogyed.gamestoreinvoicing.model.ConsoleViewModel;
//import com.trilogyed.gamestoreinvoicing.model.GameViewModel;
//import com.trilogyed.gamestoreinvoicing.model.TShirtViewModel;
//import com.trilogyed.gamestoreinvoicing.service.GameStoreInvoicingServiceLayer;
//import com.trilogyed.gamestoreinvoicing.viewmodel.InvoiceViewModel;
import com.trilogyed.gamestoreinvoicing.model.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.model.GameViewModel;
import com.trilogyed.gamestoreinvoicing.service.GameStoreInvoicingServiceLayer;
import com.trilogyed.gamestoreinvoicing.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//
@RestController
@RefreshScope
public class InvoiceController {
    @Autowired
    private GameStoreCatalogClient client;


    //
    public InvoiceController(GameStoreCatalogClient client) {
        this.client = client;
    }
    @Autowired
    private GameStoreInvoicingServiceLayer service;

    @GetMapping("/invoice/console/{id}")
    public Optional<ConsoleViewModel> getConsoleById(@PathVariable long id) {

        return client.getConsole(id);
    }

    //
    @GetMapping("/invoice/game/{id}")
    public Optional<GameViewModel> getGameById(@PathVariable long id){
       Optional<GameViewModel> game = client.getGameInfo(id);
        return game;
    }
////
////    @GetMapping("/invoice/tshirt/{id}")
////    public TShirtViewModel getTShirtById(@PathVariable int id){
////       TShirtViewModel tshirt= client.getTShirt(id);
////        return tshirt;
////    }
//
//
//
//
////    @Autowired
////    GameStoreInvoicingServiceLayer service;
//
//    // Assumption: All orders are final and data privacy is not top priority. Therefore, the Update & Delete EndPoints
//    // are left out by design due to its potential danger. The getAllInvoices is a questionable one since it could
//    // overwhelm the system and infringes on data privacy; however, it does not damage data as with the Update and Delete
//
    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel purchaseItem(@RequestBody InvoiceViewModel invoiceViewModel) {
        invoiceViewModel = service.createInvoice(invoiceViewModel);
        return invoiceViewModel;
    }

    //
////    @GetMapping("/{id}")
////    @ResponseStatus(HttpStatus.OK)
////    public InvoiceViewModel findInvoice(@PathVariable("id") long invoiceId) {
////        InvoiceViewModel invoiceViewModel = service.getInvoice(invoiceId);
////        if (invoiceViewModel == null) {
////            throw new IllegalArgumentException("Invoice could not be retrieved for id " + invoiceId);
////        } else {
////            return invoiceViewModel;
////        }
////    }
//
    @GetMapping("/invoice/console")
    public ResponseEntity<List<ConsoleViewModel>> getAllConsole() {
        return service.getAllConsoles();
    }
}
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceViewModel> findAllInvoices() {
//        List<InvoiceViewModel> invoiceViewModelList = service.getAllInvoices();
//
//        if (invoiceViewModelList == null || invoiceViewModelList.isEmpty()) {
//            throw new IllegalArgumentException("No invoices were found.");
//        } else {
//            return invoiceViewModelList;
//        }
//    }
//}
//
//    @GetMapping("/cname/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceViewModel> findInvoicesByCustomerName(@PathVariable String name) {
//        List<InvoiceViewModel> invoiceViewModelList = service.getInvoicesByCustomerName(name);
//
//        if (invoiceViewModelList == null || invoiceViewModelList.isEmpty()) {
//            throw new IllegalArgumentException("No invoices were found for: "+name);
//        } else {
//            return invoiceViewModelList;
//        }
//    }
//}
