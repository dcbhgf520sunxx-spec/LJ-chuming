const n_ = { ORDINARY_PERSONNEL: { L: "编制内", K: "ORDINARY_PERSONNEL", V: 1 }, SUBCONTRACTING_PERSONNEL: { L: "分包人员", K: "SUBCONTRACTING_PERSONNEL", V: 2 }, LABOR_PERSONNEL: { L: "编制外", K: "LABOR_PERSONNEL", V: 4 } };
ve(n_);
const s_ = { STEEL: { L: "钢结构管理系统（PLM）", K: "STEEL", V: 1 }, IOT: { L: "设备管理系统", K: "IOT", V: 2 } };
ve(s_);
const r_ = { MENU_PICK: { L: "菜单分配", K: "MENU_PICK", V: 1 }, DATA_PICK: { L: "数据分配", K: "DATA_PICK", V: 2 } };
ve(r_);
const u_ = { ALL_PERMISSION: { L: "全部数据权限", K: "ALL_PERMISSION", V: 1 }, CURRENT_DEPT_PERMISSION: { L: "本部门数据权限", K: "CURRENT_DEPT_PERMISSION", V: 2 }, CURRENT_DEPT_AND_UNDER_DEPT_PERMISSION: { L: "本部门及下属部门数据权限", K: "CURRENT_DEPT_AND_UNDER_DEPT_PERMISSION", V: 3 }, ONLY_CURRENT_USER: { L: "仅本人数据权限", K: "ONLY_CURRENT_USER", V: 4 }, CUSTOM_PERMISSION: { L: "自定义数据权限", K: "CUSTOM_PERMISSION", V: 5 }, DEPT_AND_PERSOANL: { L: "部门+个人", K: "DEPT_AND_PERSOANL", V: 6 } };
ve(u_);
const c_ = { WMS: { L: "WMS", K: "WMS", V: 1 }, SUPPLY_CHAIN: { L: "供应链", K: "SUPPLY_CHAIN", V: 2 }, CONTRACT: { L: "合同管理", K: "CONTRACT", V: 3 }, SHIP_MODULE: { L: "发运管理", K: "SHIP_MODULE", V: 4 }, PLAN_MODULE: { L: "计划管理", K: "PLAN_MODULE", V: 5 }, MES: { L: "建钢MES", K: "MES", V: 6 }, BRIDGE_MES: { L: "桥梁MES", K: "BRIDGE_MES", V: 7 }, PROJECT: { L: "项目管理", K: "PROJECT", V: 8 }, BIM: { L: "BIM", K: "BIM", V: 9 }, OPERATION: { L: "运营分析", K: "OPERATION", V: 10 }, ENCLOSURE_MES: { L: "围护MES", K: "ENCLOSURE_MES", V: 11 }, CRM: { L: "CRM", K: "CRM", V: 12 } };
ve(c_);
const d_ = { WITHIN_THE_ESTABLISHMENT: { L: "编制内", K: "WITHIN_THE_ESTABLISHMENT", V: 1 }, OUTSIDE_THE_ESTABLISHMENT: { L: "编制外", K: "OUTSIDE_THE_ESTABLISHMENT", V: 2 } };
ve(d_);
const m_ = { NEWLY_ADDED: { L: "新增", K: "NEWLY_ADDED", V: 1 }, MODIFY: { L: "修改", K: "MODIFY", V: 2 }, DELETE: { L: "删除", K: "DELETE", V: 3 }, TRUE: { L: "启用", K: "TRUE", V: 4 }, FALSE: { L: "禁用", K: "FALSE", V: 5 } };
ve(m_);
const p_ = { NUMBER: { L: "数字（0-9）", SL: "数字", K: "NUMBER", V: 1 }, SPECIAL_CHARACTERS: { L: "特殊字符", SL: "特殊字符", K: "SPECIAL_CHARACTERS", V: 2 }, LETTER: { L: "字母（Aa-Zz,区分大小写）", SL: "字母", K: "LETTER", V: 3 } };
ve(p_);
const zP = { userSexEnum: o_, systemTypeEnum: s_, menuTypeEnum: r_, permissionTypeEnum: u_, dataPermissionTypeEnum: c_, personnelTypeEnum: n_, deptTypeEnum: d_, crudTypeEnum: m_, passwordCompositionRulesEnum: p_ }, tS = Object.freeze(Object.defineProperty({ __proto__: null, crudTypeEnum: m_, dataPermissionTypeEnum: c_, default: zP, deptTypeEnum: d_, menuTypeEnum: r_, passwordCompositionRulesEnum: p_, permissionTypeEnum: u_, personnelTypeEnum: n_, systemTypeEnum: s_, userSexEnum: o_ }, Symbol.toStringTag, { value: "Module" })), C2 = Object.assign({ "./modules/bim.js": Kw, "./modules/bridge.js": Ww, "./modules/building-steel.js": nw, "./modules/capp.js": jw, "./modules/classification.js": sw, "./modules/common.js": rw, "./modules/config.js": Ay, "./modules/contract.js": ph, "./modules/crm.js": Fw, "./modules/cutting.js": zw, "./modules/dd.js": Vw, "./modules/enclosure.js": Bw, "./modules/file.js": Hw, "./modules/finance.js": E0, "./modules/logistics.js": qw, "./modules/mes.js": uw, "./modules/operation.js": Gw, "./modules/plan.js": Qw, "./modules/production.js": bw, "./modules/project.js": Zw, "./modules/ship-manage.js": Jw, "./modules/supplier.js": Xw, "./modules/system.js": $w, "./modules/uploading-form.js": eS, "./modules/user.js": tS, "./modules/wms.js": Dw }), iS = {};
for (const e in C2) iS[e.replace(/(\.\/modules\/|\.js)/g, "")] = C2[e].default;
let lm = {};
lm = Object.assign(lm, iS);
const Ra = { constantize: ve, key2val: CA, toArr: PA, getBits: Js, getBitsSum: OA, setEnumValue: DA };
Object.defineProperty(lm, "__esModule", { value: true });
function di(e, o, n = true) {
  if (Ae(e)) return "";
  const c = _e.getters.projectNameShowConfig;
  Ae(o) && (o = _e.getters.projectNameShowConfig), o.arrangement = o.arrangement || c.arrangement;
  const u = e.serialNumber || e.contractNo, r = o.showProjectFullName ? e.name : e.shortName;
  if (!o.showSerialNumber || !u) return r;
  let E = "   ";
  switch (n && (E = ` 
`), o.arrangement) {
    case nt.SERIAL_NUMBER_START.V:
      return `${u}${E}${r}`;
    case nt.SERIAL_NUMBER_END.V:
      return `${r}${E}${u}`;
    default:
      return `${r}`;
  }
}
function Hs(e, o = "createTime") {
  const n = [], c = Ra.toArr(gn), u = c.map((y) => y.V), r = [], E = function(y, b) {
    const V = -y.id;
    return -b.id - V;
  };
  return e.forEach((y) => {
    const b = Qi(y[o], "{y}");
    let V = r.indexOf(b);
    V === -1 && (r.push(b), n.push({ id: -parseInt(b), label: b, children: [] }), V = r.length - 1, c.forEach((M) => {
      n[V].children.push({ id: -Number(M.V), label: M.L, children: [] });
    })), y.label = di(y), u.indexOf(y.status) > -1 && n[V].children[u.indexOf(y.status)].children.push(y);
  }), n.sort(E), n;
}
const P2 = Ra.toArr($e), BP = { id: ci.get("projectId"), curProject: ci.get("curProject"), curProContentBit: ci.get("curProContentBit"), routeProjectType: ci.get("routeProjectType"), routeBusinessType: ci.get("routeBusinessType"), routeFilterHasEnclosure: ci.get("routeFilterHasEnclosure"), projectType: ci.get("projectType") || Ot, userProjects: [], userProjectKV: {}, userProcessProjects: [], userProjectsCascade: [], userProjectsMap: {}, userProjectsCascadeMap: {}, userBusinessTypeProjectMap: {}, userBusinessTypeProjectsCascadeMap: {}, loaded: false, projectTreeLoaded: false, projectTree: [], projectMap: {}, monomerMap: {}, areaMap: {}, userVisaProjects: [], visaLoaded: false, navbarShowAll: ci.get("navbarShowAll") || false, projectAllType: [], projectAllTypeLoaded: false }, HP = { SET_LOADED(e, o) {
  e.loaded = o;
}, SET_VISA_LOADED(e, o) {
  e.visaLoaded = o;
}, SET_PROJECT_TREE_LOADED(e, o) {
  e.projectTreeLoaded = o;
}, SET_PROJECT_ALL_TYPE_LOADED(e, o) {
  e.projectAllTypeLoaded = o;
}, SET_PROJECT_ID: (e, o) => {
  var n, c;
  e.id = o, e.curProject = e.userProjectKV[o], e.curProContentBit = ((c = (n = e.curProject) == null ? void 0 : n.projectContentList) == null ? void 0 : c.reduce((u, r) => {
    var E;
    return r.bit = r.no || ((E = r == null ? void 0 : r.childrenList) == null ? void 0 : E.reduce((y, b) => y | b.no, 0)), u | r.bit;
  }, 0)) || 0, e.curProContentBit > Xi.STRUCTURE.V && (e.curProContentBit = e.curProContentBit | Xi.BENDING.V), ci.set("projectId", o), ci.set("curProject", e.curProject), ci.set("curProContentBit", e.curProContentBit);
}, SET_PROJECT_TYPE: (e, o) => {
  e.projectType = o, ci.set("projectType", o);
}, SET_ROUTE_PROJECT_TYPE: (e, o) => {
  e.routeProjectType = o, ci.set("routeProjectType", o);
}, SET_ROUTE_FILTER_HAS_ENCLOSURE: (e, o) => {
  e.routeFilterHasEnclosure = o, ci.set("routeFilterHasEnclosure", o);
}, SET_USER_PROJECTS: (e, o = []) => {
  e.userProjects = o, e.userProcessProjects = o.filter((n) => n.status === gn.PROCESS.V), e.userProjectKV = {}, o.forEach((n) => {
    e.userProjectKV[n.id] = n;
  });
}, SET_USER_PROJECTS_MAP: (e, o) => {
  e.userProjectsMap = o;
}, SET_USER_PROJECTS_CASCADE_MAP: (e, o) => {
  e.userProjectsCascadeMap = o;
}, SET_USER_PROJECTS_CASCADE: (e, o) => {
  e.userProjectsCascade = o;
}, SET_USER_VISA_PROJECTS: (e, o) => {
  e.userVisaProjects = o;
}, SET_PROJECT_TREE: (e, o) => {
  e.projectTree = o;
}, SET_PROJECT_MAP: (e, o) => {
  e.projectMap = o;
}, SET_MONOMER_MAP: (e, o) => {
  e.monomerMap = o;
}, SET_AREA_MAP: (e, o) => {
  e.areaMap = o;
}, SET_NAVBAR_SHOW_ALL: (e, o) => {
  e.navbarShowAll = o, ci.set("navbarShowAll", o);
}, SET_USER_BUSINESS_PROJECTS_MAP: (e, o) => {
  e.userBusinessTypeProjectMap = o;
}, SET_USER_BUSINESS_PROJECTS_CASCADE_MAP: (e, o) => {
  e.userBusinessTypeProjectsCascadeMap = o;
}, SET_ROUTE_BUSINESS_TYPE: (e, o) => {
  e.routeBusinessType = o, ci.set("routeBusinessType", o);
}, SET_PROJECT_ALL_TYPE: (e, o) => {
  e.projectAllType = o;
} }, qP = { setProjectId({ commit: e }, o) {
  e("SET_PROJECT_ID", o);
}, setRouteProjectByMeta({ commit: e }, o) {
  const n = o && A(o.projectType) ? o.projectType : void 0, c = o && A(o.businessType) ? o.businessType : void 0, u = o.filterHasEnclosure || false;
  e("SET_ROUTE_PROJECT_TYPE", n), e("SET_ROUTE_FILTER_HAS_ENCLOSURE", u), e("SET_ROUTE_BUSINESS_TYPE", c);
}, async fetchUserProjects({ dispatch: e, commit: o, state: n }) {
  o("SET_LOADED", false);
  const { content: c = [] } = await oC(), u = {}, r = {}, E = {}, y = {};
  P2 && P2.forEach((b) => {
    u[b.V] = c.filter((V) => (V.projectType & b.V) > 0) || [], b.V === $e.ENCLOSURE.V && (u[b.V] = c.filter((V) => (V.projectType & b.V) > 0 || V.hasEnclosure) || []), r[b.V] = Hs(u[b.V]) || [], E[xi.MACHINING.V + "_" + b.V] = c.filter((V) => (V.projectType & b.V) > 0 && V.businessType === xi.MACHINING.V && V.status === gn.PROCESS.V) || [], E[xi.INSTALLATION.V + "_" + b.V] = c.filter((V) => (V.projectType & b.V) > 0 && V.businessType === xi.INSTALLATION.V && V.status === gn.PROCESS.V) || [], y[xi.MACHINING.V + "_" + b.V] = Hs(E[xi.MACHINING.V + "_" + b.V]) || [], y[xi.INSTALLATION.V + "_" + b.V] = Hs(E[xi.INSTALLATION.V + "_" + b.V]) || [];
  }), u[Ot] = c || [], E[xi.MACHINING.V + "_" + Ot] = c.filter((b) => b.businessType === xi.MACHINING.V && b.status === gn.PROCESS.V) || [], E[xi.INSTALLATION.V + "_" + Ot] = c.filter((b) => b.businessType === xi.INSTALLATION.V) || [], r[Ot] = Hs(c) || [], y[xi.MACHINING.V + "_" + Ot] = Hs(E[xi.MACHINING.V + "_" + Ot]) || [], y[xi.INSTALLATION.V + "_" + Ot] = Hs(E[xi.INSTALLATION.V + "_" + Ot]) || [], o("SET_USER_PROJECTS_MAP", u), o("SET_USER_PROJECTS_CASCADE_MAP", r), o("SET_USER_BUSINESS_PROJECTS_MAP", E), o("SET_USER_BUSINESS_PROJECTS_CASCADE_MAP", y), e("changeProjectType", n.projectType);
}, changeProjectType({ dispatch: e, commit: o, state: n, rootGetters: c }, u) {
  if (typeof u != "number" || u === null || u === void 0) throw Error("type为null、undefined或number类型");
  const r = u || Ot, E = n.userProjectsCascadeMap[r], y = n.userProjectsMap[r], b = y && y.map((V) => V.id) || [];
  (Ae(b) || b.indexOf(n.id) === -1 || Ae(u)) && o("SET_PROJECT_ID", void 0), o("SET_PROJECT_TYPE", r), o("SET_USER_PROJECTS", y), o("SET_USER_PROJECTS_CASCADE", E), o("SET_LOADED", true), c.permission_routes && (i6(), e("permission/setRoutes", null, { root: true }).then((V) => {
    Sd(V);
  }));
}, async fetchUserVisaProjects({ commit: e, state: o }) {
  e("SET_VISA_LOADED", false);
  const { content: n = [] } = await nC();
  n.forEach((c) => {
    c.fullName = di(c, null, false);
  }), e("SET_USER_VISA_PROJECTS", n), e("SET_VISA_LOADED", true);
}, async fetchProjectTree({ commit: e, state: o }, n) {
  e("SET_PROJECT_TREE_LOADED", false);
  const { content: c = [] } = await sC(n), u = {}, r = {}, E = {};
  c == null || c.forEach((y) => {
    var b;
    u[y.id] = y, y.fullName = di(y, null, false), (b = y == null ? void 0 : y.children) == null || b.forEach((V) => {
      var M;
      r[V.id] = V, (M = V == null ? void 0 : V.children) == null || M.forEach((g) => {
        E[g.id] = g;
      });
    });
  }), e("SET_PROJECT_TREE", c), e("SET_PROJECT_MAP", u), e("SET_MONOMER_MAP", r), e("SET_AREA_MAP", E), e("SET_PROJECT_TREE_LOADED", true);
}, async fetchProjectAllType({ commit: e, state: o }) {
  e("SET_PROJECT_ALL_TYPE_LOADED", false);
  const c = await hC() || [];
  c.forEach((u) => {
    u.fullName = di(u, null, false);
  }), e("SET_PROJECT_ALL_TYPE", c), e("SET_PROJECT_ALL_TYPE_LOADED", true);
} }, GP = { namespaced: true, state: BP, mutations: HP, actions: qP }, QP = Object.freeze(Object.defineProperty({ __proto__: null, default: GP }, Symbol.toStringTag, { value: "Module" })), Jo = ci.get("setting") || {}, aS = { logo: oP, sidebarLogo: nP, title: Jo.title || lP, showSettings: Jo.showSettings || cA, theme: Jo.theme || gA, tableBorder: Jo.tableBorder || EA, tableStripe: Jo.tableStripe || yA, tablePageSize: TA, tagsView: Jo.tagsView || dA, fixedHeader: Jo.fixedHeader || mA, showSidebarLogo: Jo.showSidebarLogo || pA, switchBackgroundColor: Jo.switchBackgroundColor || hA, projectNameShowConfig: Jo.projectNameShowConfig || sP };
ci.set("setting", aS);
const ZP = { CHANGE_SETTING: (e, o) => {
  o.forEach((n, c) => {
    Object.prototype.hasOwnProperty.call(e, c) && (e[c] = n);
  }), ci.set("setting", e);
} }, JP = { changeSetting({ commit: e }, o) {
  e("CHANGE_SETTING", o);
} }, XP = { namespaced: true, state: aS, mutations: ZP, actions: JP }, $P = Object.freeze(Object.defineProperty({ __proto__: null, default: XP }, Symbol.toStringTag, { value: "Module" })), e9 = { visitedViews: [], cachedViews: [] }, t9 = { ADD_VISITED_VIEW: (e, o) => {
  e.visitedViews.some((n) => n.path === o.path) || e.visitedViews.push(Object.assign({}, o, { title: o.meta.title || "无标题" }));
}, ADD_CACHED_VIEW: (e, o) => {
  e.cachedViews.includes(o.name) || o.meta.noCache || e.cachedViews.push(o.name);
}, DEL_VISITED_VIEW: (e, o) => {
  for (const [n, c] of e.visitedViews.entries()) if (c.path === o.path) {
    e.visitedViews.splice(n, 1);
    break;
  }
}, DEL_CACHED_VIEW: (e, o) => {
  const n = e.cachedViews.indexOf(o.name);
  n > -1 && e.cachedViews.splice(n, 1);
}, DEL_OTHERS_VISITED_VIEWS: (e, o) => {
  e.visitedViews = e.visitedViews.filter((n) => n.meta.affix || n.path === o.path);
}, DEL_OTHERS_CACHED_VIEWS: (e, o) => {
  const n = e.cachedViews.indexOf(o.name);
  n > -1 ? e.cachedViews = e.cachedViews.slice(n, n + 1) : e.cachedViews = [];
}, DEL_ALL_VISITED_VIEWS: (e) => {
  const o = e.visitedViews.filter((n) => n.meta.affix);
  e.visitedViews = o;
}, DEL_ALL_CACHED_VIEWS: (e) => {
  e.cachedViews = [];
}, UPDATE_VISITED_VIEW: (e, o) => {
  for (let n of e.visitedViews) if (n.path === o.path) {
    n = Object.assign(n, o);
    break;
  }
} }, i9 = { addView({ dispatch: e }, o) {
  e("addVisitedView", o), e("addCachedView", o);
}, addVisitedView({ commit: e }, o) {
  e("ADD_VISITED_VIEW", o);
}, addCachedView({ commit: e }, o) {
  e("ADD_CACHED_VIEW", o);
}, delView({ dispatch: e, state: o }, n) {
  return new Promise((c) => {
    e("delVisitedView", n), e("delCachedView", n), c({ visitedViews: [...o.visitedViews], cachedViews: [...o.cachedViews] });
  });
}, delVisitedView({ commit: e, state: o }, n) {
  return new Promise((c) => {
    e("DEL_VISITED_VIEW", n), c([...o.visitedViews]);
  });
}, delCachedView({ commit: e, state: o }, n) {
  return new Promise((c) => {
    e("DEL_CACHED_VIEW", n), c([...o.cachedViews]);
  });
}, delOthersViews({ dispatch: e, state: o }, n) {
  return new Promise((c) => {
    e("delOthersVisitedViews", n), e("delOthersCachedViews", n), c({ visitedViews: [...o.visitedViews], cachedViews: [...o.cachedViews] });
  });
}, delOthersVisitedViews({ commit: e, state: o }, n) {
  return new Promise((c) => {
    e("DEL_OTHERS_VISITED_VIEWS", n), c([...o.visitedViews]);
  });
}, delOthersCachedViews({ commit: e, state: o }, n) {
  return new Promise((c) => {
    e("DEL_OTHERS_CACHED_VIEWS", n), c([...o.cachedViews]);
  });
}, delAllViews({ dispatch: e, state: o }, n) {
  return new Promise((c) => {
    e("delAllVisitedViews", n), e("delAllCachedViews", n), c({ visitedViews: [...o.visitedViews], cachedViews: [...o.cachedViews] });
  });
}, delAllVisitedViews({ commit: e, state: o }) {
  return new Promise((n) => {
    e("DEL_ALL_VISITED_VIEWS"), n([...o.visitedViews]);
  });
}, delAllCachedViews({ commit: e, state: o }) {
  return new Promise((n) => {
    e("DEL_ALL_CACHED_VIEWS"), n([...o.cachedViews]);
  });
}, updateVisitedView({ commit: e }, o) {
  e("UPDATE_VISITED_VIEW", o);
} }, a9 = { namespaced: true, state: e9, mutations: t9, actions: i9 }, l9 = Object.freeze(Object.defineProperty({ __proto__: null, default: a9 }, Symbol.toStringTag, { value: "Module" })), o9 = window.__REBUILD_PUBLIC_KEY__, n9 = null;
function dr(e) {
  const o = new IV();
  return o.setPublicKey(o9), o.encrypt(e);
}
function grt() {
  return "";
}
function s9({ username: e, password: o }) {
  return W({ module: "user", url: "user/login", method: "post", data: { username: e, password: dr(o) } });
}
function r9() {
  return W({ module: "user", url: "user/info", method: "get", cancelKey: false });
}
function Ert(e) {
  return W({ url: "/api/user/info", method: "put", data: e });
}
function u9(e) {
  return W({ module: "user", url: "user/logout", method: "delete", data: { token: e } });
}
function lS() {
  return W({ module: "user", url: "user/menu", method: "get" });
}
function yrt(e) {
  const o = { oldPwd: dr(e.oldPwd), newPwd: dr(e.newPwd) };
  return W({ url: "api/user/updatePwd", method: "post", data: o });
}
function Trt(e) {
  return W({ module: "user", url: "user/send/verificationCode", method: "post", data: e });
}
function _rt(e) {
  const o = { phone: e.phone, verifyCode: e.verifyCode, confirmPassword: dr(e.confirmPassword), password: dr(e.password) };
  return W({ module: "user", url: "user/check/verificationCode", method: "post", data: o });
}
function brt(e) {
  return W({ url: "/api/config/passwordPolicy/get", method: "get", params: e });
}
function Vrt({ containLetter: e, containNumbers: o, containSpecialCharacters: n, minLength: c, loginVerification: u, password: r }) {
  const data = { containLetter: e, containNumbers: o, containSpecialCharacters: n, minLength: c, loginVerification: u };
  if (typeof r === "string" && r.trim().length > 0) data.password = dr(r);
  return W({ url: "/api/config/passwordPolicy/edit", method: "post", data });
}
const om = { requestUrl: yn(), token: or(), user: { id: "", deptId: "", name: "", username: "", email: "", dept: "", job: "", avatar: "", introduction: "", companyName: "", phone: "", sex: "", inventoryNotifyPerm: false, mesProductEnum: [], factoryProductEnum: [], mesInventoryProductEnum: [], menuSystemEnum: [], productLabelLogoPath: "", homePageShowConfig: "" }, productMenu: null, menus: [], roles: [], currentMenu: null, loadedMenus: false, projectTypeEnumArr: [$e.STEEL, $e.BRIDGE, $e.ENCLOSURE], installTypeEnumArr: [so.ARTIFACT, so.ENCLOSURE, so.AUXILIARY, so.STRAIGHTENER], deliveryInstallEnumArr: [On.ARTIFACT, On.ENCLOSURE], contractSaleTypeEnumArr: [Gl.STRUCTURE, Gl.ENCLOSURE, Gl.MACHINE_PART, Gl.AUXILIARY_MATERIAL], flag: 0, hasIntelligent: 0, hasBridgeMenu: 0, drawingMatchRange: Xc.MONOMER.V }, c9 = { SET_TOKEN: (e, o) => {
  e.token = o;
}, SET_MENUS: (e, o) => {
  e.menus = o;
}, SET_ROLES: (e, o) => {
  e.roles = o;
}, SET_PRODUCT_MENU: (e, o) => {
  e.productMenu = o;
}, SET_CURRENT_MENU: (e, o) => {
  e.currentMenu = o;
}, SET_LOAD_MENUS: (e, o) => {
  e.loadedMenus = o;
}, SET_USER: (e, { id: o, name: n = "", email: c = "", username: u = "", job: r = "", dept: E = "", deptId: y, avatar: b = "", introduction: V = "", companyName: M = "", companyLogo: rebuildCompanyLogo = null, phone: g = "", inventoryNotifyPerm: S = false, sex: h, mesProductEnum: T = [], factoryProductEnum: _ = [], mesInventoryProductEnum: f = [], oaUserId: m = "", menuSystemEnum: R = [], productLabelLogoPath: v = "", homePageShowConfig: N = "" }) => {
  e.user = { id: o, name: n, email: c, username: u, job: r, dept: E, deptId: y, avatar: b, introduction: V, companyName: M, companyLogo: rebuildCompanyLogo, phone: g, sex: h, inventoryNotifyPerm: S, mesProductEnum: T, factoryProductEnum: _, mesInventoryProductEnum: f, oaUserId: m, menuSystemEnum: R, productLabelLogoPath: v, homePageShowConfig: N };
}, SET_REQUEST_URL: (e, o) => {
  e.requestUrl = o;
}, SET_PROJECT_TYPE_ENUM_ARR: (e, o) => {
  e.projectTypeEnumArr = o;
}, SET_INSTALL_TYPE_ENUM_ARR: (e, o) => {
  e.installTypeEnumArr = o;
}, SET_DELIVERY_INSTALL_ARR: (e, o) => {
  e.deliveryInstallEnumArr = o;
}, SET_CONTRACT_SALE_TYPE_ENUM_ARR: (e, o) => {
  e.contractSaleTypeEnumArr = o;
}, SET_FLAG: (e, o) => {
  e.flag = o;
}, SET_HAS_INTELLIGENT: (e, o) => {
  e.hasIntelligent = o;
}, SET_HAS_BRIDGE_MENU: (e, o) => {
  e.hasBridgeMenu = o;
}, SET_DRAWING_MATCH_RANGE: (e, o) => {
  e.drawingMatchRange = o;
}, SET_LABEL_LOGO: (e, o) => {
  e.user.productLabelLogoPath = o;
} }, oS = { login({ commit: e }, o) {
  const n = o.rememberMe, { username: c, password: u } = o;
  return new Promise((r, E) => {
    s9({ username: c.trim(), password: u }).then((y) => {
      y.token ? (JV(y.token, n), e("SET_TOKEN", y.token), r()) : E(), y != null && y.conformPasswordPolicy || zi.alert("密码规则变动，您当前的密码不符合最新规则，请尽快前往个人中心修改密码！！！", "提示", { confirmButtonText: "确定", type: "warning" });
    }).catch((y) => {
      E(y);
    });
  });
}, getInfo({ commit: e, state: o }) {
  return new Promise((n, c) => {
    r9(o.token).then((u) => {
      oS.setInfo(u, e), n(u);
    }).catch((u) => {
      c(u);
    });
  });
}, setInfo(e, o) {
  const { permissions: n = [], roles: c = [], productMenu: u, enclosureType: r, boolSmartLine: E, boolBridge: y, drawingMatchRange: b } = e;
  let { menus: V = [] } = e;
  n.length === 0 && c.length === 0 ? o("SET_ROLES", ["ROLE_SYSTEM_DEFAULT"]) : o("SET_ROLES", n.concat(c)), V ? V.forEach((T) => {
    T.iframe || (T.redirect = T.redirect ? im(T.redirect, "/") : null);
  }) : V = [], Ai(["admin"]) && V.push({ name: "系统管理", id: -2, icon: "module-system", redirect: "/system" });
  const M = r ? [$e.STEEL, $e.BRIDGE] : [$e.STEEL, $e.ENCLOSURE, $e.BRIDGE], g = r ? [so.ARTIFACT, so.AUXILIARY] : [so.ARTIFACT, so.ENCLOSURE, so.AUXILIARY, so.STRAIGHTENER], S = r ? [On.ARTIFACT] : [On.ARTIFACT, On.ENCLOSURE], h = r ? [Gl.STRUCTURE, Gl.MACHINE_PART, Gl.AUXILIARY_MATERIAL] : [Gl.STRUCTURE, Gl.ENCLOSURE, Gl.MACHINE_PART, Gl.AUXILIARY_MATERIAL];
  console.log(h), o("SET_INSTALL_TYPE_ENUM_ARR", g), o("SET_PROJECT_TYPE_ENUM_ARR", M), o("SET_DELIVERY_INSTALL_ARR", S), o("SET_CONTRACT_SALE_TYPE_ENUM_ARR", h), o("SET_FLAG", r), o("SET_HAS_INTELLIGENT", E), o("SET_HAS_BRIDGE_MENU", y), o("SET_MENUS", V), o("SET_PRODUCT_MENU", u), o("SET_DRAWING_MATCH_RANGE", b), o("SET_USER", e), o("SET_LOAD_MENUS", false);
}, async logout({ commit: e, state: o, dispatch: n }) {
  if (o.token) await u9(o.token);
  await n("resetToken");
  await n("tagsView/delAllViews", null, { root: true });
}, updateLoadedMenus({ commit: e }) {
  return new Promise((o, n) => {
    e("SET_LOAD_MENUS", true), o();
  });
}, resetToken({ commit: e }) {
  return new Promise((o) => {
    e("SET_TOKEN", ""), e("SET_ROLES", []), e("SET_USER", {}), bA(), o();
  });
}, resetRequestUrl({ commit: e, dispatch: o }) {
  return new Promise((n) => {
    e("SET_REQUEST_URL", ""), VA(), o("logout"), n();
  });
}, setRequestUrl({ commit: e, dispatch: o }, n) {
  return new Promise((c) => {
    let u = 0;
    const r = [...n].reverse();
    for (const E in r) if (r[E] !== "/") {
      u = E;
      break;
    }
    n = n.substr(0, r.length - u), e("SET_REQUEST_URL", n), XV(n), o("api/setAPI", {}, { root: true }), c();
  });
}, async changeRoles({ commit: e, dispatch: o }, n) {
  const { content: c = [] } = await lS();
  i6();
  const u = await o("permission/generateRoutes", c, { root: true });
  Sd(u), o("tagsView/delAllViews", null, { root: true });
}, async setCurrentMenu({ commit: e }, o) {
  if (o && o.meta && o.meta.moduleId && om.menus) {
    let c = null;
    for (const u of om.menus) if (u.id === o.meta.moduleId) {
      c = u;
      break;
    }
    e("SET_CURRENT_MENU", c);
  }
} }, d9 = { namespaced: true, state: om, mutations: c9, actions: oS }, m9 = Object.freeze(Object.defineProperty({ __proto__: null, default: d9 }, Symbol.toStringTag, { value: "Module" }));
function wrt(e) {
  return W({ module: "wms", url: "material/label-print/print-record", method: "post", data: e });
}
function p9() {
  return W({ module: "wms", url: "material/label-print/not-printed-number", method: "get" });
}
function O2(e) {
  return W({ module: "wms_v2", url: "material/label-print/not-printed-number", method: "get", params: e });
}
function h9(e) {
  return W({ module: "wms_v2", url: "config/record/list", method: "get", params: e });
}
function f9(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveCheck", method: "post", data: e });
}
function g9(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveCheck", method: "post", data: e });
}
function E9(e) {
  return W({ module: "wms_v2", url: "config/record/judgeRewrite", method: "get", params: e });
}
function y9(e) {
  return W({ module: "scm_V2", url: `apply-purchase/${e}`, method: "get" });
}
function T9(e) {
  return W({ url: "/api/wms/common/getSubjoinMsgBoolShow", method: "get" });
}
function Jn(e) {
  return W({ url: `/api/v2/wms/config/record/getApproveRecordDTO/${e}`, method: "get" });
}
