//
//  NewItemViewController.swift
//  eggplant-brownie
//
//  Created by Rodrigo Alfieri on 30/06/18.
//  Copyright © 2018 Alura. All rights reserved.
//

import UIKit

class NewItemViewController: UIViewController {

    var delegate:AddAnItemDelegate?
    
    init(delegate: AddAnItemDelegate) {
        super.init(nibName: "NewItemViewController", bundle: nil)
        self.delegate = delegate
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }
    
    @IBOutlet var nameField : UITextField?
    @IBOutlet var caloriesField : UITextField?
    
    @IBAction func addNewItem() {
        let name = nameField!.text
        let calories = Double(caloriesField!.text!)
        
        if(name == nil || calories == nil || delegate == nil) {
            return
        }
        
        let item = Item(name: name!, calories: calories!)
        delegate!.add(item)
        
        if let navigation = navigationController {
            navigation.popViewController(animated: true)
        }
    }

}
