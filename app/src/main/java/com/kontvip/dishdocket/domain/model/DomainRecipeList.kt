package com.kontvip.dishdocket.domain.model

class DomainRecipeList(domainRecipes: List<DomainRecipe>) : ArrayList<DomainRecipe>(domainRecipes) {

    constructor(vararg domainRecipes: DomainRecipe) : this(domainRecipes.asList())

    interface Mapper<T> {
        fun map(domainRecipes: List<DomainRecipe>): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(this)
}