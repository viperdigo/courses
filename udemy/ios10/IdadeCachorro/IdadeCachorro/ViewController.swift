//
//  ViewController.swift
//  IdadeCachorro
//
//  Created by Rodrigo Alfieri on 24/03/18.
//  Copyright © 2018 Rodrigo Alfieri. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    
    }

    @IBOutlet weak var campoIdadeCachorro: UITextField!
    @IBOutlet weak var result: UILabel!
    
    @IBAction func findAge(_ sender: Any) {
        
        var idadeCachorro = Int(campoIdadeCachorro.text!)!
        
        idadeCachorro = idadeCachorro * 7
        
        result.text = "A idade do cchorro é " + String(idadeCachorro)
        
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

