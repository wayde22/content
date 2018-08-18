package com.wadestevens.content.models.data;

import com.wadestevens.content.models.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface InventoryDao extends CrudRepository<Inventory, Integer>{
}
