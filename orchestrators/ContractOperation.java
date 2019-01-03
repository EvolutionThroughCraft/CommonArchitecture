/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.arch.orchestrators;

import io.github.evolutionThroughCraft.common.arch.contracts.Contract;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dwin
 */
public abstract class ContractOperation<Arg, Rtn, Con extends Contract<Arg>> implements Operation<Arg, Rtn>{
    
    @Autowired
    private Con contract;
    
    @Override
    public Rtn run(Arg arg) {
        contract.validate(arg);
        return perform(arg);
    }
    
    public abstract Rtn perform(Arg arg);
}
