package fr.ubordeaux.ao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CatalogImpl implements Catalog {
    private Map<String, Reference> references;
    private Name nom;
    private HashMap<String,CatalogImpl> brothers;

    public CatalogImpl(String nom) {
        Map<String, Reference> references = new HashMap<String, Reference>();
        this.nom=new Name(nom);
    }

    public int size() {
        return references.size();
    }

    public Set<Reference> getOwnReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }

    public Set<Reference> getAllReferences() {
        Set<Reference> result = new HashSet<Reference>();
        
        this.brothers.forEach((key, value) -> {
            result.addAll(value.getOwnReferences());
        });

        return result;
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) throw new ReferenceManagementException("cannot find Reference, id unknown !");
        return references.get(id);
    }

    public void addReference(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }

    public void addBrother(CatalogImpl catalogue){
        if(this.brothers.containsKey(catalogue.nom.name)) 
            throw new IllegalArgumentException("Catalogue deja présent dans les sous catalogues");
        else{
            this.brothers.put(catalogue.nom.name,catalogue);
        }
    }
}
