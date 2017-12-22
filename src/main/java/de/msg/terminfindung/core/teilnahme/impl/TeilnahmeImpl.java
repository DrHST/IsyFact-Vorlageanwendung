package de.msg.terminfindung.core.teilnahme.impl;

/*
 * #%L
 * Terminfindung
 * %%
 * Copyright (C) 2015 - 2016 Bundesverwaltungsamt (BVA), msg systems ag
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.Map;

import de.msg.terminfindung.core.teilnahme.Teilnahme;
import de.msg.terminfindung.persistence.TeilnehmerRepository;
import de.msg.terminfindung.persistence.TeilnehmerZeitraumRepository;
import de.msg.terminfindung.persistence.entity.Praeferenz;
import de.msg.terminfindung.persistence.entity.Teilnehmer;
import de.msg.terminfindung.persistence.entity.Terminfindung;
import de.msg.terminfindung.persistence.entity.Zeitraum;

/**
 * Implementierung der Anwendungskomponente "Teilnahme" zur Teilnahme an Terminfindungen
 *
 * @author msg systems ag, Maximilian Falter, Dirk Jäger
 */
public class TeilnahmeImpl implements Teilnahme {

    private final AwfTermineBestaetigen awfTermineBestaetigen;

    public TeilnahmeImpl(TeilnehmerRepository teilnehmerDao,
        TeilnehmerZeitraumRepository teilnehmerZeitraumDao) {
        awfTermineBestaetigen = new AwfTermineBestaetigen(teilnehmerDao, teilnehmerZeitraumDao);
    }

    @Override
    public void bestaetigeTeilnahme(Terminfindung terminfindung, Teilnehmer teilnehmer,
        Map<Zeitraum, Praeferenz> terminwahl) {

        awfTermineBestaetigen.bestaetigeTeilnahme(terminfindung, teilnehmer, terminwahl);
    }

}
