/*
 * Copyright 2012 Johann Gyger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package name.gyger.jmoney.web.controller;

import name.gyger.jmoney.dto.CategoryDto;
import name.gyger.jmoney.dto.CategoryNodeDto;
import name.gyger.jmoney.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public Collection<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(path = "/split-category", method = RequestMethod.GET)
    public CategoryDto getSplitCategory() {
        return categoryService.getSplitCategory();
    }

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    public long createCategory(@RequestBody CategoryNodeDto dto) {
        return categoryService.createCategory(dto);
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @RequestMapping(path = "/category-tree", method = RequestMethod.GET)
    public CategoryNodeDto getCategoryTree() {
        return categoryService.getCategoryTree();
    }

    @RequestMapping(path = "/category-tree", method = RequestMethod.PUT)
    public void saveCategoryTree(@RequestBody CategoryNodeDto dto) {
        categoryService.saveCategoryTree(dto);
    }

}
