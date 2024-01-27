package com.coderdot.services;

import java.util.List;

public interface DthService {
    List<com.coderdot.entities.DthService> getChannelsByCategoryAndLanguage(String category, String language);
}
