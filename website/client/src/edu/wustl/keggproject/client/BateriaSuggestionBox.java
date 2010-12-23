package edu.wustl.keggproject.client;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class BateriaSuggestionBox extends SuggestBox{

	static String[] hints = { "hsa", "ptr", "mcc", "mmu", "rno", "cfa", "bta", "ssc",
			"ecb", "mdo", "oaa", "gga", "tgu", "xla", "xtr", "dre", "bfo",
			"cin", "spu", "dme", "dpo", "dan", "der", "dpe", "dse", "dsi",
			"dwi", "dya", "dgr", "dmo", "dvi", "aga", "aag", "cqu", "ame",
			"nvi", "tca", "api", "isc", "cel", "cbr", "bmy", "smm", "nve",
			"hmg", "tad", "ath", "pop", "rcu", "vvi", "osa", "sbi", "zma",
			"ppp", "cre", "olu", "cme", "sce", "ago", "kla", "lth", "dha",
			"pic", "ppa", "pgu", "vpo", "lel", "zro", "cal", "ctp", "cdu",
			"cgr", "yli", "clu", "spo", "ncr", "pan", "mgr", "fgr", "ani",
			"afm", "aor", "ang", "afv", "act", "pcs", "nfi", "cim", "ure",
			"ssl", "bfu", "pno", "cne", "cnb", "ppl", "lbc", "mpr", "uma",
			"mgl", "ecu", "mbr", "ddi", "ehi", "edi", "pfa", "pfd", "pfh",
			"pyo", "pcb", "pbe", "pkn", "pvx", "tan", "tpv", "bbo", "cpv",
			"cho", "tgo", "tet", "ptm", "tbr", "tcr", "lma", "lif", "lbz",
			"gla", "tva", "pti", "tps", "eco", "ecj", "ecd", "ebw", "ece",
			"ecs", "ecf", "etw", "ecg", "ecc", "eci", "ecp", "ecv", "ecw",
			"ecx", "ecm", "ecy", "ecl", "eck", "ecq", "ecr", "ect", "ecz",
			"eum", "elf", "ebl", "ebd", "ebr", "eoh", "eoi", "eoj", "eok",
			"efe", "sty", "stt", "stm", "spt", "sek", "spq", "sei", "sec",
			"seh", "see", "sew", "sea", "sed", "seg", "set", "ses", "ype",
			"ypk", "ypm", "ypa", "ypn", "ypg", "ypp", "yps", "ypi", "ypy",
			"ypb", "yen", "sfl", "sfx", "sfv", "ssn", "sbo", "sbc", "sdy",
			"eca", "pct", "pwa", "eta", "epy", "plu", "pay", "buc", "bas",
			"bab", "bcc", "bap", "bau", "wbr", "sgl", "ent", "esa", "ctu",
			"kpn", "kpe", "kpu", "kva", "cko", "cro", "spe", "pmr", "eic",
			"etr", "bfl", "bpn", "hde", "dda", "ddc", "dze", "xbo", "hin",
			"hit", "hip", "hiq", "hdu", "hap", "hso", "hsm", "pmu", "msu",
			"apl", "apj", "apa", "asu", "aap", "aat", "xfa", "xft", "xfm",
			"xfn", "xcc", "xcb", "xca", "xcv", "xac", "xoo", "xom", "xop",
			"xal", "sml", "smt", "vch", "vco", "vcm", "vcj", "vvu", "vvy",
			"vpa", "vha", "vsp", "vex", "vfi", "vfm", "vsa", "ppr", "pae",
			"pau", "pap", "pag", "ppu", "ppf", "ppg", "ppw", "pst", "psb",
			"psp", "pfl", "pfo", "pfs", "pen", "pmy", "psa", "cja", "avn",
			"par", "pcr", "prw", "aci", "acb", "abm", "aby", "abc", "abn",
			"abb", "son", "sdn", "sfr", "saz", "sbl", "sbm", "sbn", "sbp",
			"slo", "spc", "sse", "spl", "she", "shm", "shn", "shw", "shl",
			"swd", "swp", "ilo", "cps", "pha", "pat", "sde", "maq", "amc",
			"pin", "ttu", "cbu", "cbs", "cbd", "cbg", "cbc", "lpn", "lpf",
			"lpp", "lpc", "llo", "mca", "ftu", "ftf", "ftw", "ftl", "fth",
			"fta", "ftm", "ftn", "fph", "tcx", "noc", "alv", "aeh", "hha",
			"tgr", "tkm", "hna", "hch", "csa", "abo", "mmw", "aha", "asa",
			"tau", "dno", "afe", "afr", "bci", "crp", "rma", "vok", "kko",
			"nma", "nme", "nmc", "nmn", "nmi", "ngo", "ngk", "cvi", "lhk",
			"rso", "rpi", "rpf", "reu", "reh", "rme", "cti", "bma", "bmv",
			"bml", "bmn", "bps", "bpm", "bpl", "bpd", "bpr", "bte", "bvi",
			"bur", "bcn", "bch", "bcm", "bcj", "bam", "bac", "bmu", "bmj",
			"bxe", "bph", "bpy", "bgl", "pnu", "pne", "bpe", "bpa", "bbr",
			"bpt", "bav", "rfr", "pol", "pna", "aav", "ajs", "dia", "vei",
			"dac", "vap", "ctt", "mpt", "har", "mms", "lch", "neu", "net",
			"nmu", "eba", "azo", "dar", "tmz", "tbd", "mfa", "mmb", "mei",
			"app", "hpy", "hpj", "hpa", "hps", "hpg", "hpp", "hpb", "hhe",
			"hac", "hms", "wsu", "tdn", "cje", "cjr", "cjj", "cju", "cjd",
			"cff", "ccv", "cha", "cco", "cla", "abu", "sdl", "nis", "sun",
			"nam", "gsu", "gme", "gur", "glo", "gbm", "geo", "gem", "pca",
			"ppd", "dvu", "dvl", "dvm", "dde", "dds", "dma", "dsa", "lip",
			"dba", "drt", "bba", "dps", "dol", "dal", "dat", "ade", "acp",
			"afw", "ank", "mxa", "scl", "hoh", "sat", "sfu", "rpr", "rty",
			"rcm", "rco", "rfe", "rak", "rri", "rrj", "rms", "rpk", "raf",
			"rbe", "rbo", "ots", "ott", "wol", "wbm", "wri", "wpi", "ama",
			"amf", "acn", "aph", "eru", "erw", "erg", "ecn", "ech", "nse",
			"nri", "pub", "mlo", "mes", "pla", "sme", "smd", "atu", "atc",
			"ara", "avi", "ret", "rec", "rle", "rlt", "rlg", "rhi", "las",
			"bme", "bmi", "bmf", "bmb", "bmc", "bms", "bmt", "bov", "bcs",
			"bmr", "oan", "bja", "bra", "bbt", "rpa", "rpb", "rpc", "rpd",
			"rpe", "rpt", "nwi", "nha", "oca", "bhe", "bqu", "bbk", "btr",
			"bgr", "xau", "azc", "mex", "mea", "mdi", "mrd", "met", "mpo",
			"mch", "mno", "bid", "msl", "hci", "ccr", "ccs", "cak", "pzu",
			"sil", "sit", "rsp", "rsh", "rsq", "rsk", "jan", "rde", "pde",
			"dsh", "mmr", "hne", "hba", "zmo", "zmn", "nar", "sal", "swi",
			"eli", "gox", "gbe", "acr", "gdi", "gdj", "apt", "rru", "rce",
			"mag", "azl", "mgm", "bsu", "bha", "ban", "bar", "baa", "bat",
			"bah", "bai", "bce", "bca", "bcz", "bcr", "bcb", "bcu", "bcg",
			"bcq", "bcx", "bcy", "btk", "btl", "bwe", "bli", "bld", "bcl",
			"bay", "bpu", "bpf", "oih", "gka", "gtn", "gwc", "gym", "gyc",
			"afl", "sau", "sav", "saw", "sah", "saj", "sam", "sas", "sar",
			"sac", "sax", "saa", "sao", "sae", "sad", "sab", "sep", "ser",
			"sha", "ssp", "sca", "slg", "lmo", "lmf", "lmh", "lmc", "lmn",
			"lmy", "lin", "lwe", "lsg", "lsp", "esi", "eat", "mcl", "bbe",
			"pjd", "aac", "lla", "llk", "llc", "llm", "spy", "spz", "spm",
			"spg", "sps", "sph", "spi", "spj", "spk", "spf", "spa", "spb",
			"soz", "spn", "spd", "spr", "spw", "spx", "sne", "spv", "snm",
			"sjj", "spp", "snt", "sag", "san", "sak", "smu", "smc", "stc",
			"stl", "ste", "ssa", "ssu", "ssv", "ssb", "ssi", "sss", "sgo",
			"seq", "sez", "seu", "sub", "sds", "sga", "smb", "lpl", "lpj",
			"ljo", "ljf", "lac", "lsa", "lsl", "ldb", "lbu", "lbr", "lca",
			"lcb", "lga", "lre", "lrf", "lhe", "lfe", "lrh", "lrl", "ppe",
			"efa", "ooe", "lme", "lci", "cac", "cpe", "cpf", "cpr", "ctc",
			"cno", "cth", "cdf", "cdc", "cdl", "cbo", "cba", "cbh", "cby",
			"cbl", "cbk", "cbb", "cbi", "cbt", "cbf", "cbe", "ckl", "ckr",
			"cpy", "cce", "amt", "aoe", "sth", "swo", "vpr", "afn", "ate",
			"dsy", "dhd", "drm", "dae", "pth", "dau", "hmo", "fma", "apr",
			"eel", "ere", "clo", "tte", "tex", "tpd", "tit", "chy", "mta",
			"adg", "csc", "cpo", "nth", "hor", "mge", "mpn", "mpu", "mpe",
			"mga", "mmy", "mmo", "mhy", "mhj", "mhp", "msy", "mcp", "maa",
			"mal", "mat", "mco", "mho", "uur", "upa", "uue", "poy", "ayw",
			"pml", "pal", "acl", "mfl", "mtu", "mtc", "mra", "mtf", "mtb",
			"mbo", "mbb", "mbt", "mle", "mlb", "mpa", "mav", "msm", "mul",
			"mva", "mgi", "mab", "mmc", "mkm", "mjl", "mmi", "cgl", "cgb",
			"cgt", "cef", "cdi", "cjk", "cur", "car", "ckp", "nfa", "rha",
			"rer", "rop", "gbr", "sco", "sma", "sgr", "scb", "twh", "tws",
			"lxx", "cmi", "cms", "art", "aau", "ach", "rsa", "krh", "mlu",
			"rmu", "bcv", "bfa", "jde", "kse", "xce", "pac", "nca", "kfl",
			"tfu", "tcu", "sro", "fra", "fre", "fal", "ace", "nml", "gob",
			"kra", "sen", "svi", "ami", "stp", "saq", "cai", "sna", "blo",
			"blj", "bln", "bad", "bla", "blc", "blt", "bde", "gva", "rxy",
			"cwo", "afo", "ccu", "shi", "apv", "ele", "ctr", "cta", "ctb",
			"ctl", "ctj", "cmu", "cpn", "cpa", "cpj", "cpt", "cca", "cab",
			"cfe", "pcu", "bbu", "bbz", "bga", "baf", "btu", "bhr", "bdu",
			"bre", "tpa", "tpp", "tde", "lil", "lic", "lbj", "lbl", "lbi",
			"lbf", "bhy", "aba", "aca", "sus", "bth", "bfr", "bfs", "bvu",
			"pgi", "pgn", "pdi", "aps", "sru", "rmr", "chu", "dfe", "sli",
			"cpi", "phe", "gfo", "fjo", "fps", "fba", "coc", "rbi", "smg",
			"sms", "bbl", "bpi", "aas", "fsu", "fnu", "lba", "str", "smf",
			"ote", "min", "amu", "gau", "rba", "psl", "emi", "rsd", "tai",
			"syn", "syw", "syc", "syf", "syd", "sye", "syg", "syr", "syx",
			"syp", "cya", "cyb", "tel", "mar", "cyt", "cyp", "cyc", "cyn",
			"cyh", "cyu", "gvi", "ana", "npu", "ava", "pma", "pmm", "pmt",
			"pmn", "pmi", "pmb", "pmc", "pmf", "pmg", "pmh", "pmj", "pme",
			"ter", "amr", "cte", "cpc", "cch", "cph", "cpb", "cli", "pvi",
			"plt", "pph", "paa", "cts", "det", "deh", "deb", "dev", "deg",
			"rrs", "rca", "cau", "cag", "chl", "hau", "tro", "sti", "dra",
			"dge", "ddr", "tth", "ttj", "mrb", "aae", "hya", "hth", "tal",
			"sul", "saf", "pmx", "tma", "tpt", "tle", "trq", "tna", "tnp",
			"tme", "taf", "fno", "pmo", "kol", "dth", "dtu", "tye", "ttr",
			"ddf", "dap", "mja", "mfe", "mvu", "mfs", "mmp", "mmq", "mmx",
			"mmz", "mae", "mvn", "mac", "mba", "mma", "mbu", "mtp", "mhu",
			"mla", "mem", "mbn", "mpl", "mpd", "mth", "mst", "msi", "mru",
			"mka", "afu", "apo", "fpl", "hal", "hsl", "hma", "hwa", "nph",
			"hla", "hut", "hmu", "htu", "nmg", "tac", "tvo", "pto", "pho",
			"pab", "pfu", "tko", "ton", "tga", "tsi", "abi", "rci", "ape",
			"smr", "iho", "dka", "hbu", "sso", "sto", "sai", "sis", "sia",
			"sim", "sid", "siy", "sin", "sii", "mse", "pai", "pis", "pcl",
			"pas", "cma", "tne", "tpe", "nmr", "neq", "kcr" };

	static String[] realname = { "H.sapiens", "P.troglodytes", "M.mulatta",
			"M.musculus", "R.norvegicus", "C.familiaris", "B.taurus",
			"S.scrofa", "E.caballus", "M.domestica", "O.anatinus", "G.gallus",
			"T.guttata", "X.laevis", "X.tropicalis", "D.rerio", "B.floridae",
			"C.intestinalis", "S.purpuratus", "D.melanogaster",
			"D.pseudoobscura", "D.ananassae", "D.erecta", "D.persimilis",
			"D.sechellia", "D.simulans", "D.willistoni", "D.yakuba",
			"D.grimshawi", "D.mojavensis", "D.virilis", "A.gambiae",
			"A.aegypti", "C.quinquefasciatus", "A.mellifera", "N.vitripennis",
			"T.castaneum", "A.pisum", "I.scapularis", "C.elegans",
			"C.briggsae", "B.malayi", "S.mansoni", "N.vectensis",
			"H.magnipapillata", "T.adhaerens", "A.thaliana", "P.trichocarpa",
			"R.communis", "V.vinifera", "O.sativa", "S.bicolor", "Z.mays",
			"P.patens_patens", "C.reinhardtii", "O.lucimarinus", "C.merolae",
			"S.cerevisiae", "A.gossypii", "K.lactis", "L.thermotolerans",
			"D.hansenii", "P.stipitis", "P.pastoris", "P.guilliermondii",
			"V.polyspora", "L.elongisporus", "Z.rouxii", "C.albicans",
			"C.tropicalis", "C.dubliniensis", "C.glabrata", "Y.lipolytica",
			"C.lusitaniae", "S.pombe", "N.crassa", "P.anserina", "M.grisea",
			"F.graminearum", "A.nidulans", "A.fumigatus", "A.oryzae",
			"A.niger", "A.flavus", "A.clavatus", "P.chrysogenum", "N.fischeri",
			"C.immitis", "U.reesii", "S.sclerotiorum", "B.fuckeliana",
			"P.nodorum", "C.neoformans", "C.neoformans_B3501A", "P.placenta",
			"L.bicolor", "M.perniciosa", "U.maydis", "M.globosa", "E.cuniculi",
			"M.brevicollis", "D.discoideum", "E.histolytica", "E.dispar",
			"P.falciparum", "P.falciparum_Dd2", "P.falciparum_HB3", "P.yoelii",
			"P.chabaudi", "P.berghei", "P.knowlesi", "P.vivax", "T.annulata",
			"T.parva", "B.bovis", "C.parvum", "C.hominis", "T.gondii",
			"T.thermophila", "P.tetraurelia", "T.brucei", "T.cruzi", "L.major",
			"L.infantum", "L.braziliensis", "G.lamblia", "T.vaginalis",
			"P.tricornutum", "T.pseudonana", "E.coli", "E.coli_J",
			"E.coli_DH10B", "E.coli_BW2952", "E.coli_O157", "E.coli_O157J",
			"E.coli_O157_EC4115", "E.coli_O157_TW14359", "E.coli_0127",
			"E.coli_CFT073", "E.coli_UTI89", "E.coli_536", "E.coli_APEC",
			"E.coli_E24377A", "E.coli_HS", "E.coli_SECEC", "E.coli_SE11",
			"E.coli_ATCC8739", "E.coli_55989", "E.coli_ED1a", "E.coli_IAI1",
			"E.coli_IAI39", "E.coli_S88", "E.coli_UMN026", "E.coli_LF82",
			"E.coli_BL21", "E.coli_BL21_DE3", "E.coli_B_REL606",
			"E.coli_O103_H2", "E.coli_O111_H-", "E.coli_O26_H11",
			"E.coli_O55_H7", "E.fergusonii", "S.typhi", "S.typhi_Ty2",
			"S.typhimurium", "S.enterica_Paratyphi",
			"S.enterica_Paratyphi_AKU12601", "S.enterica_Paratyphi_B",
			"S.enterica_Paratyphi_C", "S.enterica_Choleraesuis",
			"S.enterica_Heidelberg", "S.enterica_Newport",
			"S.enterica_Schwarzengrund", "S.enterica_Agona",
			"S.enterica_Dublin", "S.enterica_Gallinarum",
			"S.enterica_Enteritidis", "S.enterica_arizonae", "Y.pestis",
			"Y.pestis_KIM", "Y.pestis_Mediaevails", "Y.pestis_Antiqua",
			"Y.pestis_Nepal516", "Y.pestis_Angola", "Y.pestis_Pestoides",
			"Y.pseudotuberculosis", "Y.pseudotuberculosis_IP31758",
			"Y.pseudotuberculosis_YPIII", "Y.pseudotuberculosis_PB1",
			"Y.enterocolitica", "S.flexneri", "S.flexneri_2457T",
			"S.flexneri_8401", "S.sonnei", "S.boydii", "S.boydii_CDC3083-94",
			"S.dysenteriae", "E.carotovora", "P.carotovorum", "P.wasabiae",
			"E.tasmaniensis", "E.pyrifoliae", "P.luminescens", "P.asymbiotica",
			"Buchnera", "B.aphidicola_Sg", "B.aphidicola_Bp",
			"B.aphidicola_Cc", "B.aphidicola_5A", "B.aphidicola_Tuc7",
			"W.brevipalpis", "S.glossinidius", "Enterobacter_638",
			"E.sakazakii", "C.turicensis", "K.pneumoniae", "K.pneumoniae_342",
			"K.pneumoniae_NTUH-K2044", "K.variicola", "C.koseri",
			"C.rodentium", "S.proteamaculans", "P.mirabilis", "E.ictaluri",
			"E.tarda", "B.floridanus", "B.pennsylvanicus", "H.defensa",
			"D.dadantii", "D.dadantii_Ech586", "D.zeae", "X.bovienii",
			"H.influenzae", "H.influenzae_NT", "H.influenzae_PittEE",
			"H.influenzae_PittGG", "H.ducreyi", "H.parasuis", "H.somnus",
			"H.somnus_2336", "P.multocida", "M.succiniciproducens",
			"A.pleuropneumoniae", "A.pleuropneumoniae_JL03",
			"A.pleuropneumoniae_AP76", "A.succinogenes", "A.aphrophilus",
			"A.actinomycetemcomitans", "X.fastidiosa", "X.fastidiosa_T",
			"X.fastidiosa_M12", "X.fastidiosa_M23", "X.campestris",
			"X.campestris_B", "X.campestris_B100", "X.campestris_vesicatoria",
			"X.axonopodis", "X.oryzae", "X.oryzae_MAFF311018",
			"X.oryzae_PXO99A", "X.albilineans", "S.maltophilia",
			"S.maltophilia_R551-3", "V.cholerae", "V.cholerae_O395",
			"V.cholerae_M66-2", "V.cholerae_MJ-1236", "V.vulnificus",
			"V.vulnificus_YJ016", "V.parahaemolyticus", "V.harveyi",
			"V.splendidus", "Vibrio_Ex25", "V.fischeri", "V.fischeri_MJ11",
			"A.salmonicida_LFI1238", "P.profundum", "P.aeruginosa",
			"P.aeruginosa_PA14", "P.aeruginosa_PA7", "P.aeruginosa_LESB58",
			"P.putida", "P.putida_F1", "P.putida_GB1", "P.putida_W619",
			"P.syringae", "P.syringae_B728a", "P.syringae_phaseolicola",
			"P.fluorescens", "P.fluorescens_PfO1", "P.fluorescens_SBW25",
			"P.entomophila", "P.mendocina", "P.stutzeri", "C.japonicus",
			"A.vinelandii", "P.arcticum", "P.cryohalolentis",
			"Psychrobacter_PRwf-1", "Acinetobacter_ADP1", "A.baumannii",
			"A.baumannii_SDF", "A.baumannii_AYE", "A.baumannii_ACICU",
			"A.baumannii_AB0057", "A.baumannii_AB307-0294", "S.oneidensis",
			"S.denitrificans", "S.frigidimarina", "S.amazonensis", "S.baltica",
			"S.baltica_OS185", "S.baltica_OS195", "S.baltica_OS223",
			"S.loihica", "S.putrefaciens", "S.sediminis", "S.pealeana",
			"Shewanella_MR-4", "Shewanella_MR-7", "Shewanella_ANA3",
			"Shewanella_W3-18-1", "S.halifaxensis", "S.woodyi",
			"S.piezotolerans_WP3", "I.loihiensis", "C.psychrerythraea",
			"P.haloplanktis", "P.atlantica", "S.degradans", "M.aquaeolei",
			"A.macleodii", "P.ingrahamii", "T.turnerae", "C.burnetii",
			"C.burnetii_RSA331", "C.burnetii_Dugway", "C.burnetii_CbuG_Q212",
			"C.burnetii_CbuK_Q154", "L.pneumophila", "L.pneumophila_Lens",
			"L.pneumophila_Paris", "L.pneumophila_Corby", "L.longbeachae",
			"M.capsulatus", "F.tularensis", "F.tularensis_FSC198",
			"F.tularensis_WY96-3418", "F.tularensis_LVS", "F.tularensis_OSU18",
			"F.tularensis_FTA", "F.tularensis_FSC147", "F.tularensis_U112",
			"F.philomiragia", "T.crunogena", "N.oceani", "A.vinosum",
			"A.ehrlichei", "H.halophila", "Thioalkalivibrio_HL-EbGR7",
			"Thioalkalivibrio_K90mix", "H.neapolitanus", "H.chejuensis",
			"C.salexigens", "A.borkumensis", "Marinomonas_MWYL1",
			"A.hydrophila", "A.salmonicida", "T.auensis", "D.nodosus",
			"A.ferrooxidans", "A.ferrooxidans_ATCC23270", "B.cicadellinicola",
			"C.ruddii", "R.magnifica", "V.okutanii", "K.koreensis",
			"N.meningitidis_A", "N.meningitidis", "N.meningitidis_FAM18",
			"N.meningitidis_053442", "N.meningitidis_alpha14", "N.gonorrhoeae",
			"N.gonorrhoeae_NCCP11945", "C.violaceum", "L.hongkongensis",
			"R.solanacearum", "R.pickettii", "R.pickettii_12D", "R.eutropha",
			"R.eutropha_H16", "R.metallidurans", "C.taiwanensis", "B.mallei",
			"B.mallei_SAVP1", "B.mallei_NCTC10229", "B.mallei_NCTC10247",
			"B.pseudomallei", "B.pseudomallei_1710b", "B.pseudomallei_1106a",
			"B.pseudomallei_668", "B.pseudomallei_MSHR346", "B.thailandensis",
			"B.vietnamiensis", "Burkholderia_383", "B.cenocepacia",
			"B.cenocepacia_HI2424", "B.cenocepacia_MC0-3",
			"B.cenocepacia_J2315", "B.cepacia", "B.ambifaria_MC40-6",
			"B.multivorans", "B.multivorans_T", "B.xenovorans", "B.phymatum",
			"B.phytofirmans", "B.glumae", "Polynucleobacter", "P.necessarius",
			"B.pertussis", "B.parapertussis", "B.bronchiseptica", "B.petrii",
			"B.avium", "R.ferrireducens", "Polaromonas", "P.naphthalenivorans",
			"A.avenae", "Acidovorax_JS42", "Diaphorobacter", "V.eiseniae",
			"D.acidovorans", "V.paradoxus", "C.testosteroni",
			"M.petroleiphilum", "H.arsenicoxydans", "M.massiliensis",
			"L.cholodnii", "N.europaea", "N.eutropha", "N.multiformis",
			"Azoarcus_EbN1", "Azoarcus_BH72", "D.aromatica", "Thauera",
			"T.denitrificans", "M.flagellatus", "M.mobilis",
			"Methylovorus_SIP3-4", "A.phosphatis", "H.pylori", "H.pylori_J99",
			"H.pylori_HPAG1", "H.pylori_Shi470", "H.pylori_G27",
			"H.pylori_P12", "H.pylori_B38", "H.hepaticus", "H.acinonychis",
			"H.mustelae", "W.succinogenes", "T.denitrificans_ATCC33889",
			"C.jejuni", "C.jejuni_RM1221", "C.jejuni_81-176", "C.jejuni_81116",
			"C.jejuni_doylei", "C.fetus", "C.curvus", "C.hominis_BAA-381",
			"C.concisus", "C.lari", "A.butzleri", "S.deleyianum",
			"Nitratiruptor_SB155-2", "Sulfurovum_NBC37-1", "N.profundicola",
			"G.sulfurreducens", "G.metallireducens", "G.uraniumreducens",
			"G.lovleyi", "G.bemidjiensis", "Geobacter_FRC-32", "Geobacter_M21",
			"P.carbinolicus", "P.propionicus", "D.vulgaris", "D.vulgaris_DP4",
			"D.vulgaris_Miyazaki_F", "D.desulfuricans",
			"D.desulfuricans_ATCC27774", "D.magneticus", "D.salexigens",
			"L.intracellularis", "D.baculatum", "D.retbaense",
			"B.bacteriovorus", "D.psychrophila", "D.oleovorans",
			"D.alkenivorans", "D.autotrophicum", "A.dehalogenans",
			"A.dehalogenans_2CP-1", "Anaeromyxobacter_Fw109-5",
			"Anaeromyxobacter_K", "M.xanthus", "S.cellulosum", "H.ochraceum",
			"S.aciditrophicus", "S.fumaroxidans", "R.prowazekii", "R.typhi",
			"R.canadensis", "R.conorii", "R.felis", "R.akari", "R.rickettsii",
			"R.rickettsii_Iowa", "R.massiliae", "R.peacockii", "R.africae",
			"R.bellii", "R.bellii_OSU85-389", "O.tsutsugamushi",
			"O.tsutsugamushi_Ikeda", "Wolbachia_Mel", "Wolbachia_Bma",
			"Wolbachia_wRi", "W.pipientis", "A.marginale",
			"A.marginale_Florida", "A.centrale", "A.phagocytophilum",
			"E.ruminantium", "E.ruminantium_Welgevonden",
			"E.ruminantium_Gardel", "E.canis", "E.chaffeensis", "N.sennetsu",
			"N.risticii", "P.ubique", "M.loti", "Mesorhizobium_BNC1",
			"P.lavamentivorans", "S.meliloti", "S.medicae", "A.tumefaciens",
			"A.tumefaciens_C", "A.radiobacter", "A.vitis", "R.etli",
			"R.etli_CIAT652", "R.leguminosarum", "R.leguminosarum_trifolii",
			"R.leguminosarum_trifolii_WSM1325", "Rhizobium_NGR234",
			"L.asiaticus", "B.melitensis", "B.melitensis_ATCC23457",
			"B.melitensis_Abortus", "B.abortus", "B.abortus_S19", "B.suis",
			"B.suis_ATCC23445", "B.ovis", "B.canis", "B.microti", "O.anthropi",
			"B.japonicum", "Bradyrhizobium_ORS278", "Bradyrhizobium_BTAi1",
			"R.palustris", "R.palustris_HaA2", "R.palustris_BisB18",
			"R.palustris_BisB5", "R.palustris_BisA53", "R.palustris_TIE-1",
			"N.winogradskyi", "N.hamburgensis", "O.carboxidovorans",
			"B.henselae", "B.quintana", "B.bacilliformis", "B.tribocorum",
			"B.grahamii", "X.autotrophicus", "A.caulinodans", "M.extorquens",
			"M.extorquens_AM1", "M.dichloromethanicum", "M.radiotolerans",
			"Methylobacterium_4-46", "M.populi", "M.chloromethanicum",
			"M.nodulans", "B.indica", "M.silvestris", "H.cicadicola",
			"C.crescentus", "C.crescentus_NA1000", "Caulobacter_K31",
			"P.zucineum", "S.pomeroyi", "Silicibacter_TM1040", "R.sphaeroides",
			"R.sphaeroides_ATCC17029", "R.sphaeroides_ATCC17025",
			"R.sphaeroides_KD131", "Jannaschia_CCS1", "R.denitrificans",
			"P.denitrificans", "D.shibae", "M.maris", "H.neptunium",
			"H.baltica", "Z.mobilis", "Z.mobilis_NCIMB11163",
			"N.aromaticivorans", "S.alaskensis", "S.wittichii", "E.litoralis",
			"G.oxydans", "G.bethesdensis", "A.cryptum", "G.diazotrophicus",
			"G.diazotrophicus_J", "A.pasteurianus", "R.rubrum", "R.centenum",
			"M.magneticum", "Azospirillum_B510", "Magnetococcus_MC1",
			"B.subtilis", "B.halodurans", "B.anthracis",
			"B.anthracis_Ames0581", "B.anthracis_A2012", "B.anthracis_Sterne",
			"B.anthracis_CDC684", "B.anthracis_A0248", "B.cereus",
			"B.cereus_ATCC10987", "B.cereus_ZK", "B.cereus_AH187",
			"B.cereus_B4264", "B.cereus_AH820", "B.cereus_G9842",
			"B.cereus_Q1", "B.cereus_03BB102", "B.cereus_NVH",
			"B.thuringiensis", "B.thuringiensis_AlHakam",
			"B.weihenstephanensis", "B.licheniformis", "B.licheniformis_DSM13",
			"B.clausii", "B.amyloliquefaciens", "B.pumilus", "B.pseudofirmus",
			"O.iheyensis", "G.kaustophilus", "G.thermodenitrificans",
			"Geobacillus_WCH70", "Geobacillus_Y412MC10",
			"Geobacillus_Y412MC61", "A.flavithermus", "S.aureus_N315",
			"S.aureus_Mu50", "S.aureus_Mu3", "S.aureus_JH1", "S.aureus_JH9",
			"S.aureus_MW2", "S.aureus_MSSA476", "S.aureus_MRSA252",
			"S.aureus_COL", "S.aureus_USA300_TCH1516", "S.aureus_USA300",
			"S.aureus_NCTC8325", "S.aureus_Newman", "S.aureus_ED98",
			"S.aureus_RF122", "S.epidermidis", "S.epidermidis_RP62A",
			"S.haemolyticus", "S.saprophyticus", "S.carnosus", "S.lugdunensis",
			"L.monocytogenes", "L.monocytogenes_F2365",
			"L.monocytogenes_HCC23", "L.monocytogenes_Clip81459",
			"L.monocytogenes_08-5578", "L.monocytogenes_08-5923", "L.innocua",
			"L.welshimeri", "L.seeligeri", "L.sphaericus", "E.sibiricum",
			"Exiguobacterium_AT1b", "M.caseolyticus", "B.brevis",
			"Paenibacillus", "A.acidocaldarius", "L.lactis", "L.lactis_KF147",
			"L.lactis_SK11", "L.lactis_MG1363", "S.pyogenes",
			"S.pyogenes_MGAS5005", "S.pyogenes_M18", "S.pyogenes_M3",
			"S.pyogenes_SSI1", "S.pyogenes_MGAS10270", "S.pyogenes_MGAS10750",
			"S.pyogenes_MGAS2096", "S.pyogenes_MGAS9429",
			"S.pyogenes_Manfredo", "S.pyogenes_MGAS10394",
			"S.pyogenes_MGAS6180", "S.pyogenes_NZ131", "S.pneumoniae",
			"S.pneumoniae_D39", "S.pneumoniae_R6", "S.pneumoniae_CGSP14",
			"S.pneumoniae_G54", "S.pneumoniae_ATCC700669",
			"S.pneumoniae_Hungary19A_6", "S.pneumoniae_70585",
			"S.pneumoniae_JJA", "S.pneumoniae_P1031",
			"S.pneumoniae_Taiwan19F-14", "S.agalactiae", "S.agalactiae_NEM316",
			"S.agalactiae_A909", "S.mutans", "S.mutans_NN2025",
			"S.thermophilus_CNRZ", "S.thermophilus_LMG", "S.thermophilus_LMD9",
			"S.sanguinis", "S.suis_05ZYH33", "S.suis_98HAH33", "S.suis_BM407",
			"S.suis_P1-7", "S.suis_SC84", "S.gordonii", "S.equi_zooepidemicus",
			"S.equi", "S.equi_equi", "S.uberis", "S.dysgalactiae",
			"S.gallolyticus", "S.mitis_B6", "L.plantarum", "L.plantarum_JDM1",
			"L.johnsonii", "L.johnsonii_FI9785", "L.acidophilus", "L.sakei",
			"L.salivarius", "L.delbrueckii", "L.delbrueckii_BAA-365",
			"L.brevis", "L.casei", "L.casei_BL23", "L.gasseri", "L.reuteri",
			"L.reuteri_K", "L.helveticus", "L.fermentum", "L.rhamnosus",
			"L.rhamnosus_Lc705", "P.pentosaceus", "E.faecalis", "O.oeni",
			"L.mesenteroides", "L.citreum", "C.acetobutylicum",
			"C.perfringens", "C.perfringens_ATCC13124", "C.perfringens_SM101",
			"C.tetani", "C.novyi", "C.thermocellum", "C.difficile",
			"C.difficile_CD196", "C.difficile_R20291", "C.botulinum",
			"C.botulinum_A_ATCC19397", "C.botulinum_A_Hall", "C.botulinum_A2",
			"C.botulinum_A3_LochMaree", "C.botulinum_B_Eklund",
			"C.botulinum_B1", "C.botulinum_Ba4", "C.botulinum_E3",
			"C.botulinum_F", "C.beijerinckii", "C.kluyveri", "C.kluyveri_NBRC",
			"C.phytofermentans", "C.cellulolyticum", "A.metalliredigens",
			"A.oremlandii", "S.thermophilum", "S.wolfei", "V.parvula",
			"A.fermentans", "A.thermophilum", "D.hafniense",
			"D.hafniense_DCB-2", "D.reducens", "D.acetoxidans",
			"P.thermopropionicum", "D.audaxviator", "H.modesticaldum",
			"F.magna", "A.prevotii", "E.eligens", "E.rectale",
			"Clostridiales_BVAB3", "T.tengcongensis",
			"Thermoanaerobacter_X514", "T.pseudethanolicus", "T.italicus",
			"C.hydrogenoformans", "M.thermoacetica", "A.degensii",
			"C.saccharolyticus", "C.proteolyticus", "N.thermophilus",
			"H.orenii", "M.genitalium", "M.pneumoniae", "M.pulmonis",
			"M.penetrans", "M.gallisepticum", "M.mycoides", "M.mobile",
			"M.hyopneumoniae", "M.hyopneumoniae_J", "M.hyopneumoniae_7448",
			"M.synoviae", "M.capricolum", "M.agalactiae", "M.agalactiae_5632",
			"M.arthritidis", "M.conjunctivae", "M.hominis", "U.urealyticum",
			"U.parvum", "U.urealyticum_10", "Phytoplasma_OY",
			"Phytoplasma_AYWB", "Phytoplasma_mali", "Phytoplasma_australiense",
			"A.laidlawii", "M.florum", "M.tuberculosis",
			"M.tuberculosis_CDC1551", "M.tuberculosis_H37Ra",
			"M.tuberculosis_F11", "M.tuberculosis_KZN1435", "M.bovis",
			"M.bovis_BCG", "M.bovis_BCG_Tokyo", "M.leprae", "M.leprae_Br4923",
			"M.avium_paratuberculosis", "M.avium_104", "M.smegmatis",
			"M.ulcerans", "M.vanbaalenii", "M.gilvum", "M.abscessus",
			"Mycobacterium_MCS", "Mycobacterium_KMS", "Mycobacterium_JLS",
			"M.marinum", "C.glutamicum", "C.glutamicum_B", "C.glutamicum_R",
			"C.efficiens", "C.diphtheriae", "C.jeikeium", "C.urealyticum",
			"C.aurimucosum", "C.kroppenstedtii", "N.farcinica",
			"Rhodococcus_RHA1", "R.erythropolis", "R.opacus", "G.bronchialis",
			"S.coelicolor", "S.avermitilis", "S.griseus", "S.scabiei",
			"T.whipplei", "T.whipplei_S", "L.xyli", "C.michiganensis",
			"C.michiganensis_sepedonicus", "Arthrobacter_FB24", "A.aurescens",
			"A.chlorophenolicus", "R.salmoninarum", "K.rhizophila", "M.luteus",
			"R.mucilaginosa", "B.cavernae", "B.faecium", "J.denitrificans",
			"K.sedentarius", "X.cellulosilytica", "P.acnes",
			"Nocardioides_JS614", "K.flavida", "T.fusca", "T.curvata",
			"S.roseum", "Frankia_CcI3", "Frankia_EAN1pec", "F.alni",
			"A.cellulolyticus", "N.multipartita", "G.obscurus",
			"K.radiotolerans", "S.erythraea", "S.viridis", "A.mirum",
			"S.tropica", "S.arenicola", "C.acidiphila", "S.nassauensis",
			"B.longum", "B.longum_DJO10A", "B.longum_infantis_ATCC15697",
			"B.adolescentis", "B.animalis_lactis", "B.animalis_lactis_Bl-04",
			"B.animalis_lactis_DSM10140", "B.dentium", "G.vaginalis",
			"R.xylanophilus", "C.woesei", "A.ferrooxidans_DSM10331",
			"C.curtum", "S.heliotrinireducens", "A.parvulum", "E.lenta",
			"C.trachomatis", "C.trachomatis_A", "C.trachomatis_434Bu",
			"C.trachomatis_L2b", "C.trachomatis_Jali20", "C.muridarum",
			"C.pneumoniae", "C.pneumoniae_AR39", "C.pneumoniae_J138",
			"C.pneumoniae_TW183", "C.caviae", "C.abortus", "C.felis",
			"Parachlamydia_UWE25", "B.burgdorferi", "B.burgdorferi_ZS7",
			"B.garinii", "B.afzelii", "B.turicatae", "B.hermsii", "B.duttonii",
			"B.recurrentis", "T.pallidum", "T.pallidum_SS14", "T.denticola",
			"L.interrogans", "L.interrogans_Copenhageni",
			"L.borgpetersenii_JB197", "L.borgpetersenii_L550", "L.biflexa",
			"L.biflexa_Patoc1_Ames", "B.hyodysenteriae", "A.bacterium",
			"A.capsulatum", "S.usitatus", "B.thetaiotaomicron", "B.fragilis",
			"B.fragilis_NCTC9343", "B.vulgatus", "P.gingivalis",
			"P.gingivalis_ATCC33277", "P.distasonis", "A.pseudotrichonymphae",
			"S.ruber", "R.marinus", "C.hutchinsonii", "D.fermentans",
			"S.linguale", "C.pinensis", "P.heparinus", "G.forsetii",
			"F.johnsoniae", "F.psychrophilum", "F.bacterium", "C.ochracea",
			"R.biformata", "S.muelleri", "S.muelleri_SMDSEM",
			"Blattabacterium_Blattella_germanica",
			"Blattabacterium_Periplaneta_americana", "A.asiaticus",
			"F.succinogenes", "F.nucleatum", "L.buccalis", "S.termitidis",
			"S.moniliformis", "O.terrae", "M.infernorum", "A.muciniphila",
			"G.aurantiaca", "R.baltica", "P.staleyi", "E.minutum", "Rs-D17",
			"T.acidaminovorans", "Synechocystis", "Synechococcus_WH8102",
			"Synechococcus_PCC6301", "Synechococcus_PCC7942",
			"Synechococcus_CC9605", "Synechococcus_CC9902",
			"Synechococcus_CC9311", "Synechococcus_RCC307",
			"Synechococcus_WH7803", "Synechococcus_PCC7002",
			"Cyanobacteria_CYA", "Cyanobacteria_CYB", "T.elongatus",
			"M.aeruginosa", "Cyanothece_ATCC51142", "Cyanothece_PCC8801",
			"Cyanothece_PCC7424", "Cyanothece_PCC7425", "Cyanothece_PCC8802",
			"Cyanobacterium_UCYN-A", "G.violaceus", "Anabaena",
			"N.punctiforme", "A.variabilis", "P.marinus", "P.marinus_MED4",
			"P.marinus_MIT9313", "P.marinus_NATL2A", "P.marinus_MIT9312",
			"P.marinus_AS9601", "P.marinus_MIT9515", "P.marinus_MIT9303",
			"P.marinus_MIT9301", "P.marinus_MIT9215", "P.marinus_MIT9211",
			"P.marinus_NATL1A", "T.erythraeum", "A.marina", "C.tepidum",
			"C.parvum_NCIB8327", "C.chlorochromatii", "C.phaeobacteroides",
			"C.phaeobacteroides_BS1", "C.limicola", "P.vibrioformis",
			"P.luteolum", "P.phaeoclathratiforme", "P.aestuarii",
			"C.thalassium", "D.ethenogenes", "Dehalococcoides_CBDB1",
			"Dehalococcoides_BAV1", "Dehalococcoides_VS", "Dehalococcoides_GT",
			"Roseiflexus_RS-1", "R.castenholzii", "C.aurantiacus",
			"C.aggregans", "Chloroflexus_Y-400-fl", "H.aurantiacus",
			"T.roseum", "S.thermophilus", "D.radiodurans", "D.geothermalis",
			"D.deserti", "T.thermophilus", "T.thermophilus_HB8", "M.ruber",
			"A.aeolicus", "Hydrogenobaculum_Y04AAS1", "H.thermophilus",
			"T.albus", "Sulfurihydrogenibium_YO3AOP1", "S.azorense",
			"P.marina", "T.maritima", "T.petrophila", "T.lettingae",
			"Thermotoga_RQ2", "T.neapolitana", "T.naphthophila",
			"T.melanesiensis", "T.africanus", "F.nodosum", "P.mobilis",
			"K.olearia", "D.thermophilum", "D.turgidum", "T.yellowstonii",
			"T.terrenum", "D.desulfuricans_SSM1", "D.acetiphilus",
			"M.jannaschii", "M.fervens", "M.vulcanius",
			"Methanocaldococcus_FS406-22", "M.maripaludis", "M.maripaludis_C5",
			"M.maripaludis_C6", "M.maripaludis_C7", "M.aeolicus",
			"M.vannielii", "M.acetivorans", "M.barkeri", "M.mazei",
			"M.burtonii", "M.thermophila", "M.hungatei", "M.labreanum",
			"M.marisnigri", "M.boonei", "M.palustris", "M.paludicola",
			"M.thermoautotrophicum", "M.stadtmanae", "M.smithii",
			"M.ruminantium", "M.kandleri", "A.fulgidus", "A.profundus",
			"F.placidus", "Halobacterium", "H.salinarum", "H.marismortui",
			"H.walsbyi", "N.pharaonis", "H.lacusprofundi", "H.utahensis",
			"H.mukohataei", "H.turkmenica", "N.magadii", "T.acidophilum",
			"T.volcanium", "P.torridus", "P.horikoshii", "P.abyssi",
			"P.furiosus", "T.kodakaraensis", "T.onnurineus", "T.gammatolerans",
			"T.sibiricus", "A.boonei", "RC-I_MRE50", "A.pernix", "S.marinus",
			"I.hospitalis", "D.kamchatkensis", "H.butylicus", "S.solfataricus",
			"S.tokodaii", "S.acidocaldarius", "S.islandicus_L.S.2.15",
			"S.islandicus_M.14.25", "S.islandicus_M.16.27",
			"S.islandicus_M.16.4", "S.islandicus_Y.G.57.14",
			"S.islandicus_Y.N.15.51", "S.islandicus_L.D.8.5", "M.sedula",
			"P.aerophilum", "P.islandicum", "P.calidifontis", "P.arsenaticum",
			"C.maquilingensis", "T.neutrophilus", "T.pendens", "N.maritimus",
			"N.equitans", "K.cryptofilum" };
	static MultiWordSuggestOracle oracle;
	
	static{
		oracle = new MultiWordSuggestOracle();
		for (int i =0; i< hints.length; i++) {
			oracle.add(hints[i] + " " + realname[i]);
		}
	}
	public BateriaSuggestionBox() {
		super(oracle);
	}
}
