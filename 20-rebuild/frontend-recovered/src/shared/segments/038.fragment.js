const _9 = { add: f9, edit: g9, get: h9 };
function b9(e) {
  return W({ module: "config", url: "steel-density", method: "get", params: e });
}
function Srt(e) {
  return W({ module: "config", url: "steel-density/save", method: "post", data: e });
}
function vrt(e) {
  return W({ module: "config", url: "steel-density/deleted", method: "delete", data: e });
}
function Rrt(e) {
  return W({ module: "config", url: "steel-density/update", method: "put", data: e });
}
function Mrt(e) {
  return W({ module: "config", url: "steel-density/getSteelClass", method: "get", params: e });
}
function V9() {
  return W({ module: "config", url: "steel-density/getAll", method: "get", cancelKey: false });
}
const Art = { get: b9 }, w9 = { baseUnit: vi, purchaseCfg: {}, inboundSteelCfg: {}, inboundFillWayCfg: {}, outboundCfg: {}, rejectCfg: {}, reportCfg: {}, partyABorrowReturnCfg: {}, basicShowCfg: {}, materialWeightingCfg: {}, notPrintedMaterialNumber: { totalMaterial: 0, inboundMaterial: 0, outboundMaterial: 0, transferMaterial: 0, returnMaterial: 0 }, notPrintedMaterialBoolPartyANumber: { totalMaterial: 0, inboundMaterial: 0, outboundMaterial: 0, transferMaterial: 0, returnMaterial: 0 }, notPrintedMaterialNotBoolPartyANumber: { totalMaterial: 0, inboundMaterial: 0, outboundMaterial: 0, transferMaterial: 0, returnMaterial: 0 }, returnCfg: {}, inventoryLossCfg: {}, subjoinMsgBool: false, steelDensityCfg: {}, coilPlateConvertList: [], produceOutboundEditConf: {}, priceAbnormal: [], loaded: { config: false, notPrintedMaterialBoolPartyANumber: false, notPrintedMaterialNotBoolPartyANumber: false, notPrintedMaterialNumber: false, subjoinMsgBool: false, steelDensityCfg: false } }, S9 = { SET_MAT_BASE_UNIT(e, o) {
  e.matBaseUnit = o;
}, SET_LOADED(e, { key: o, loaded: n = true }) {
  console.log(o, "key"), e.loaded[o] = n, console.log(e.loaded);
}, SET_PURCHASE_CFG(e, o) {
  e.purchaseCfg = o;
}, SET_INBOUND_STEEL_CFG(e, o) {
  e.inboundSteelCfg = o;
}, SET_INBOUND_FILL_WAY_CFG(e, o) {
  e.inboundFillWayCfg = o;
}, SET_OUTBOUND_CFG(e, o) {
  e.outboundCfg = o;
}, SET_REJECT_CFG(e, o) {
  e.rejectCfg = o;
}, SET_REPORT_CFG(e, o) {
  e.reportCfg = o;
}, SET_PARTY_A_BORROW_RETURN_CFG(e, o) {
  e.partyABorrowReturnCfg = o;
}, SET_MATERIAL_WEIGHTING_CFG(e, o) {
  e.materialWeightingCfg = o;
}, SET_NOT_PRINTED_MATERIAL_NUMBER(e, o) {
  e.notPrintedMaterialNumber = o;
}, SET_NOT_PRINTED_MATERIAL_BOOLPARTYA_NUMBER(e, o) {
  e.notPrintedMaterialBoolPartyANumber = o;
}, SET_NOT_PRINTED_MATERIAL_NOT_BOOLPARTYA_NUMBER(e, o) {
  e.notPrintedMaterialNotBoolPartyANumber = o;
}, SET_STEEL_DENSITY(e, o) {
  e.steelDensityCfg = o;
}, SET_RETURN_CFG(e, o) {
  e.returnCfg = o;
}, SET_INVENTORY_LOSS_CFG(e, o) {
  e.inventoryLossCfg = o;
}, SET_SUBJOIN_MSG_BOOL(e, o) {
  e.subjoinMsgBool = o;
}, SET_COIL_PLATE_CONVERT_LIST(e, o) {
  const n = [];
  o == null || o.forEach((c) => {
    const u = c.classifyColorRollIds.map((r) => r.id);
    n.push(...u);
  }), e.coilPlateConvertList = n;
}, SET_PRODUCE_OUTBOUND_CONFIG(e, o) {
  e.produceOutboundEditConf = o;
}, SET_PRICE_ABNORMAL(e, o) {
  e.priceAbnormal = o;
} }, v9 = { fetchConfigInfo() {
  console.log("TODO：加载配置文件");
}, async fetchWmsConfig({ commit: e }) {
  var g, S;
  vA(), MA();
  const o = await wI(), { inbound: n = {}, purchaseSpec: c = {}, outbound: u = {}, reject: r = {}, report: E = {}, partyABorrowReturn: y = {}, basicShow: b = {}, weightedPrice: V = {} } = o;
  e("SET_PURCHASE_CFG", c);
  const M = { ...n.fillWay, trainsDiff: (g = n.steel) == null ? void 0 : g.trainsDiff, trainsDiffType: (S = n.steel) == null ? void 0 : S.trainsDiffType };
  SA(n.fillWay.steelWeightCalculationType || Zn.TOTAL.V), RA(b.steelsSpeShowConfig || mo.RIGHT_SPEC.V), e("SET_INBOUND_STEEL_CFG", M), e("SET_INBOUND_FILL_WAY_CFG", n.fillWay), e("SET_OUTBOUND_CFG", u), e("SET_REJECT_CFG", r), e("SET_REPORT_CFG", E), e("SET_PARTY_A_BORROW_RETURN_CFG", y), e("SET_MATERIAL_WEIGHTING_CFG", V), e("SET_RETURN_CFG", o.return || {}), e("SET_INVENTORY_LOSS_CFG", o.deficit || {}), e("SET_COIL_PLATE_CONVERT_LIST", o.convert || []), e("SET_PRODUCE_OUTBOUND_CONFIG", o.outboundUpdate || {}), e("SET_PRICE_ABNORMAL", o.priceAbnormal || []), e("SET_LOADED", { key: "config" });
}, async fetchNotPrintedMaterialNumber({ commit: e }) {
  const { totalMaterial: o = 0, inboundMaterial: n = 0, outboundMaterial: c = 0, transferMaterial: u = 0, returnMaterial: r = 0 } = await p9();
  e("SET_NOT_PRINTED_MATERIAL_NUMBER", { totalMaterial: o, inboundMaterial: n, outboundMaterial: c, transferMaterial: u, returnMaterial: r }), e("SET_LOADED", { key: "notPrintedMaterialNumber" });
}, async fetchNotPrintedMaterialBoolPartyANumber({ commit: e }) {
  const { totalMaterial: o = 0, inboundMaterial: n = 0, outboundMaterial: c = 0, transferMaterial: u = 0, returnMaterial: r = 0 } = await O2({ boolPartyA: true });
  e("SET_NOT_PRINTED_MATERIAL_BOOLPARTYA_NUMBER", { totalMaterial: o, inboundMaterial: n, outboundMaterial: c, transferMaterial: u, returnMaterial: r }), e("SET_LOADED", { key: "notPrintedMaterialBoolPartyANumber" });
}, async fetchNotPrintedMaterialNotBoolPartyANumber({ commit: e }) {
  const { totalMaterial: o = 0, inboundMaterial: n = 0, outboundMaterial: c = 0, transferMaterial: u = 0, returnMaterial: r = 0, surplusMaterial: E = 0 } = await O2({ boolPartyA: false });
  e("SET_NOT_PRINTED_MATERIAL_NOT_BOOLPARTYA_NUMBER", { totalMaterial: o, inboundMaterial: n, outboundMaterial: c, transferMaterial: u, returnMaterial: r, surplusMaterial: E }), e("SET_LOADED", { key: "notPrintedMaterialNotBoolPartyANumber" });
}, async fetchSteelDensityCfg({ commit: e }) {
  const o = await V9();
  e("SET_STEEL_DENSITY", o), e("SET_LOADED", { key: "steelDensityCfg" });
}, async fetchSetSubjoinMsgBool({ commit: e }) {
  const o = await T9();
  e("SET_SUBJOIN_MSG_BOOL", o), e("SET_LOADED", { key: "subjoinMsgBool" });
} }, R9 = { namespaced: true, state: w9, mutations: S9, actions: v9 }, M9 = Object.freeze(Object.defineProperty({ __proto__: null, default: R9 }, Symbol.toStringTag, { value: "Module" })), A9 = { sidebar: (e) => e.app.sidebar, device: (e) => e.app.device, baseApi: (e) => e.api.baseApi, fileUploadApi: (e) => e.api.fileUploadApi, fileUploadCompanyLogoApi: (e) => e.api.fileUploadCompanyLogoApi, axiosCancelTokens: (e) => e.interface.axiosCancelTokens, logo: (e) => e.settings.logo, sidebarLogo: (e) => e.settings.sidebarLogo, projectNameShowConfig: (e) => e.settings.projectNameShowConfig, showSettings: (e) => e.settings.showSettings, tagsView: (e) => e.settings.tagsView, fixedHeader: (e) => e.settings.fixedHeader, showSidebarLogo: (e) => e.settings.showSidebarLogo, title: (e) => e.settings.title, switchBackgroundColor: (e) => e.settings.switchBackgroundColor, homePageShowConfig: (e) => e.user.user.homePageShowConfig, tableBorder: (e) => e.settings.tableBorder, tableStripe: (e) => e.settings.tableStripe, tablePageSize: (e) => e.settings.tablePageSize, visitedViews: (e) => e.tagsView.visitedViews, company: (e) => e.config.company, watermark: (e) => e.config.watermark, clsTree: (e) => e.config.clsTree, matClsTree: (e) => e.config.matClsTree, classifySpec: (e) => e.config.classifySpec, matClsSpecKV: (e) => e.config.classifySpec.specKV, userDeptTree: (e) => e.config.userDeptTree, baseUnit: (e) => e.wms.baseUnit, steelDensityCfg: (e) => e.wms.steelDensityCfg, token: (e) => e.user.token, user: (e) => e.user.user, requestUrl: (e) => e.user.requestUrl, inventoryNotifyPerm: (e) => e.user.user.inventoryNotifyPerm, roles: (e) => e.user.roles, menus: (e) => e.user.menus, productMenu: (e) => e.user.productMenu, currentMenu: (e) => e.user.currentMenu, loadedMenus: (e) => e.user.loadedMenus, routes: (e) => e.permission.routes, userProjects: (e) => e.project.userProjects, projectMap: (e) => e.project.projectMap, globalProjectId: (e) => e.project.id, globalProject: (e) => e.project.curProject, globalProContentBit: (e) => e.project.curProContentBit, currentProjectType: (e) => e.project.projectType, navbarShowAll: (e) => e.project.navbarShowAll, currentProject: (e) => e.project.currentProject, routeProjectType: (e) => e.project.routeProjectType, routeFilterHasEnclosure: (e) => e.project.routeFilterHasEnclosure, projectsCascade: (e) => e.project.projectsCascade, projectsCascadeMap: (e) => e.project.projectsCascadeMap, routeBusinessType: (e) => e.project.routeBusinessType, projectTypeEnumArr: (e) => e.user.projectTypeEnumArr, installTypeEnumArr: (e) => e.user.installTypeEnumArr, deliveryInstallEnumArr: (e) => e.user.deliveryInstallEnumArr, contractSaleTypeEnumArr: (e) => e.user.contractSaleTypeEnumArr, flag: (e) => e.user.flag, hasIntelligent: (e) => e.user.hasIntelligent, hasBridgeMenu: (e) => e.user.hasBridgeMenu, closingTimeConfig: (e) => e.config.closingTimeConfig, loadedClosingTimeConfig: (e) => e.config.loaded.closingTimeConfig, drawingMatchRange: (e) => e.user.drawingMatchRange }, k2 = Object.assign({ "./modules/api.js": HN, "./modules/app.js": JN, "./modules/approval_list.js": X5, "./modules/config.js": WC, "./modules/crm.js": JC, "./modules/interface.js": iP, "./modules/permission.js": RP, "./modules/project.js": QP, "./modules/settings.js": $P, "./modules/tagsView.js": l9, "./modules/user.js": m9, "./modules/wms.js": M9 }), rc = {};
for (const e in k2) rc[e.replace(/(\.\/modules\/|\.js)/g, "")] = k2[e].default;
Object.keys(rc).forEach((e) => {
  rc[e].namespaced = true;
});
const _e = M6({ modules: rc, getters: A9 }), W = CV.create({ timeout: 6e5, headers: { "Content-Type": "application/json" }, cancelKey: true }), N9 = CV.CancelToken, D2 = _e.getters.axiosCancelTokens, L9 = _e.getters.baseApi;
W.interceptors.request.use((e) => {
  const o = yn();
  if (!o || mw(o) ? e.baseURL = o : setTimeout(() => {
    zi.confirm("您填写的公司地址无法正常访问，可以取消继续留在该页面，或者重新填写访问地址", "确定重写", { confirmButtonText: "重写地址", cancelButtonText: "取消", type: "warning" }).then(() => {
      _e.dispatch("user/resetRequestUrl"), location.reload();
    });
  }, 500), e.module && (e.url = L9[e.module] + e.url), or() && (e.headers.Authorization = or()), S2() && (e.headers.financeBranchId = S2()), (e.data === null || e.data === void 0) && (e.data = {}), (e.params === null || e.params === void 0) && (e.params = {}), e.headers["Content-Type"] === "application/x-www-form-urlencoded" && (e.data = w2.stringify(e.data)), e.method === "get" && (e.paramsSerializer = (n) => w2.stringify(n, { arrayFormat: "repeat" })), e.cancelKey) {
    const n = typeof e.cancelKey == "boolean" ? `${e.method}|${e.url}` : e.cancelKey;
    D2[n] && D2[n].cancel({ cancel: true, message: `取消了接口：${n}` });
    const c = N9.source();
    e.cancelToken = c.token, _e.dispatch("interface/setAxiosCancelTokens", { cancelKey: n, source: c });
  }
  return e;
}, (e) => {
  console.log(e), Promise.reject(e);
});
W.interceptors.response.use((e) => {
  if (e.config.responseType === "blob" || e.config.responseType === "arraybuffer") return e;
  const o = e.data;
  if ([40001, 40002, 40003, 40004, 40005, 40103].includes(o.code)) {
    bA();
    _e.commit("user/SET_TOKEN", "");
    _e.commit("user/SET_ROLES", []);
    if (location.pathname !== "/login") location.assign("/login");
    const error = new Error(o.message || "登录已失效，请重新登录");
    error.code = o.code;
    return Promise.reject(error);
  }
  if (o.code === 2e4) return rebuildNormalizeAttachmentUrls(o.data);
  if (o.code === 40206) return ot({ message: o.message, type: "error" }), o;
  switch (o.code) {
    case 40001:
    case 40002:
      zi.confirm("你已被登出，可以取消继续留在该页面，或者重新登录", "确定登出", { confirmButtonText: "重新登录", cancelButtonText: "取消", type: "warning" }).then(() => {
        _e.dispatch("user/logout");
      }).finally(() => {
        location.reload();
      });
      break;
    default:
      o.message && ot({ message: o.message, type: "error", duration: 5 * 1e3 });
  }
  return Promise.reject("error");
}, (e) => Promise.reject(e));
const I9 = Object.freeze(Object.defineProperty({ __proto__: null, default: W }, Symbol.toStringTag, { value: "Module" }));
function nS(e) {
  return W({ module: "wms", url: "material/inventory/reminder", method: "get", params: e, cancelKey: false });
}
function Nrt(e) {
  return W({ module: "wms", url: `inbound/application/review/theory-thickness/${e}`, method: "get", cancelKey: false });
}
function sS(e) {
  return W({ module: "wms", url: "report/raw-materials/template/excel", method: "get", params: e, responseType: "blob" });
}
function uu(e) {
  return W({ module: "wms_v2", url: "report/raw-materials/template/excel", method: "get", params: e, responseType: "blob" });
}
function Tt() {
  const e = +/* @__PURE__ */ new Date() + "";
  return (+(parseInt((1 + Math.random()) * 65536) + "" + e)).toString(32);
}
function pi(e) {
  return typeof e != "string" ? e : e.replace(/(^\s*)|(\s*$)/g, "");
}
const Lrt = { pattern: /^[a-zA-Z][0-9a-zA-Z]{3,16}$/, message: "4-16位字母或数字，首位为字母" }, Irt = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/, Crt = /^1([38]\d|4[014-9]|5[0-35-9]|6[2567]|7[0-8]|9[0-35-9])\d{8}$/, Prt = /^(0\d{2}-\d{8}(-\d{1,4})?)|(0\d{3}-\d{7,8}(-\d{1,4})?)$|1([38]\d|4[014-9]|5[0-35-9]|6[2567]|7[0-8]|9[0-35-9])\d{8}$/, Ort = /^(?=^.{3,255}$)(http(s)?:\/\/)?(www\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\d+)*(\/\w+\.\w+)*$/, uc = /^[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY]·?[A-Z0-9]{5,6}[挂学警港澳]?$/, C9 = /^([0-9]|1[0-9]|20)$/, $o = /^-?[0-9]+.?[0-9]*$/, krt = /^[+]{0,1}(\d+)$/, Vi = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, Drt = { pattern: /^[\u4e00-\u9fa5A-Za-z\p{P}\p{S}]+$/u, message: "请填写汉字、字母或符号" }, xrt = { pattern: /^[A-Za-z0-9]+$/, message: "请填写英文或数字" }, Urt = { pattern: /^[A-Z]{1,5}$/, message: "请输入1-5位大写英文字母" };
function h_(e) {
  if (!A(e)) return "";
  var o = e.lastIndexOf("."), n = e.length;
  if (o !== -1) {
    var c = e.substring(o + 1, n);
    return c;
  } else return "";
}
async function rS(e) {
  const o = this, n = Array.prototype.slice.call(arguments);
  n.shift();
  try {
    const c = await e.apply(o, n);
    if (console.log(c), uS(c)) Di({ title: "导出成功", type: "success", duration: 2 * 1e3 });
    else throw Di({ title: "导出失败", type: "error", duration: 2 * 1e3 }), Error("导出失败");
  } catch (c) {
    throw Error(c);
  }
}
async function P9(e) {
  const o = this, n = Array.prototype.slice.call(arguments);
  n.shift();
  try {
    const c = await e.apply(o, n);
    x9(c);
  } catch (c) {
    throw Error(c);
  }
}
function uS(e, o) {
  const n = e.data, c = e.headers;
  if (!n || !c) return false;
  const u = c["content-type"];
  if (u === "application/json;charset=UTF-8") return false;
  const r = new Blob([n], { type: u }), E = document.createElement("a"), y = window.URL.createObjectURL(r);
  E.href = y, o || (o = cS(e));
  const b = o.split("."), V = JSON.parse(JSON.stringify(b)) || [];
  return V == null || V.splice(b.length - 1, 1), o = `${V.join(".")}_${Qi(/* @__PURE__ */ new Date(), "{y}{m}{d}{h}{i}{s}")}.${b[b.length - 1]}`, E.download = o, document.body.appendChild(E), E.click(), document.body.removeChild(E), window.URL.revokeObjectURL(y), true;
}
function O9(e, { accept: o, sizeLimit: n }) {
  if (o && !(o.split(",").indexOf(`.${h_(e.name).toLowerCase()}`) > -1)) return ot.error(`上传文件后缀需为${o}格式`, 2e3), false;
  const c = e.size / 1024 / 1024;
  return !n || n && c < n ? true : (ot.error(`上传文件大小大小不能超过 ${n}MB!`, 2e3), false);
}
function k9(e) {
  return new Promise((o, n) => {
    var c = e, u = new FileReader();
    FileReader.prototype.readAsBinaryString = function(r) {
      var E = "", y, b, V = new FileReader();
      V.onload = (M) => {
        for (var g = new Uint8Array(V.result), S = g.byteLength, h = 0; h < S; h++) E += String.fromCharCode(g[h]);
        y = Yi.read(E, { type: "binary" }), b = Yi.utils.sheet_to_json(y.Sheets[y.SheetNames[0]]), o(b);
      }, V.readAsArrayBuffer(r);
    }, u.readAsBinaryString(c);
  });
}
async function D9(e, o = {}) {
  const n = [], c = o.startRow || 0, u = o.endIgnoreRow || 0, r = o.fields;
  return e.length >= c && r && e.slice(c - 1, e.length - u).forEach((y) => {
    const b = {};
    r.forEach((V) => {
      b[V.field] = pi(y[V.excelField]), V.type === "number" ? (b[V.field] = Number(b[V.field]), C9.test(V.precision) && (b[V.field] = Be(b[V.field], V.precision))) : typeof b[V.field] == "number" && (b[V.field] = String(b[V.field]));
    }), n.push(b);
  }), typeof o.format == "function" ? await o.format(n) : n;
}
function cS(e) {
  const o = e.headers, n = o && o["content-disposition"] ? o["content-disposition"].split("=")[1].split(".") : [];
  if (!n || n.length === 0) return false;
  const c = `${decodeURIComponent(n.pop())}`;
  return c ? `${`${decodeURIComponent(n.join("."))}`}.${c}` : false;
}
function x9(e, { fileName: o, successMsg: n, errorMsg: c } = {}) {
  const u = e.headers.result && decodeURIComponent(e.headers.result).split(";");
  if (console.log("res", e), u) {
    const r = u[0].split("=")[1], E = u[1].split("=")[1], y = cS(e) || "";
    r === "20000" ? (Di.success({ title: `${o || y}下载请求成功, 正在下载`, message: n }), uS(e, y)) : Di.error({ title: `${o || y}下载请求失败`, message: c || `${E}` });
  } else Di.error("下载请求失败");
}
const vs = {};
vs.KEY_PREFIX = "ADD_FORM";
vs.TYPE = { normal: 1, browserClose: 2 };
function U9(e, { useDraftCallback: o, clearDraftCallback: n } = {}) {
  const { CRUD: c, crud: u } = ed(), r = Ct({ key: e, expired: 6048e5, form: u.form, initForm: void 0, init: void 0, isRegister: false, saveStoreForm: () => {
    const E = dS(r);
    return u.cancelCU(), E;
  }, resetForm: () => {
    x2(r), u.resetForm(), r.init && r.init(), typeof n == "function" && n();
  } });
  return c.HOOK.afterToAdd = () => K9(r, o), c.HOOK.beforeAddCancel = () => Ad(r), c.HOOK.afterAddSuccess = () => {
    x2(r), Ad(r);
  }, bl(() => {
    U2(r, u), Ad(r);
  }), window.onbeforeunload = () => {
    U2(r, u);
  }, yi("fmStore", r), r;
}
function Y9(e) {
  e.initForm = void 0;
}
function K9(e, o) {
  const n = j9(e.key);
  if (Ae(n)) e.init && e.init();
  else {
    const c = n.content;
    W9(e.form, c), typeof o == "function" && o(e.form);
  }
  e.initForm = uo.cloneDeep(e.form), e.isRegister = true;
}
function Ad(e) {
  e.isRegister = false, Y9(e);
}
function W9(e, o) {
  for (const n in e) e[n] = void 0;
  for (const n in o) e[n] = o[n];
}
function dS(e, o, n = vs.TYPE.normal) {
  if (!e.isRegister) return false;
  const c = o || e.form;
  try {
    return ci.set(`${vs.KEY_PREFIX}_${e.key}`, { type: n, content: c }, e.expired), true;
  } catch (u) {
    return console.log("缓存错误信息", u), console.log("缓存", c), false;
  }
}
function x2(e) {
  ci.remove(`${vs.KEY_PREFIX}_${e.key}`);
}
function U2(e, o) {
  if (!e.isRegister) return;
  o.status.cu > 0 && !tu(e.initForm, e.form) && dS(e, null, vs.TYPE.browserClose);
}
function j9(e) {
  return ci.get(`${vs.KEY_PREFIX}_${e}`);
}
const Rs = {};
Rs.KEY_PREFIX = "ADD_BATCH_FORM";
Rs.TYPE = { normal: 1, browserClose: 2 };
function F9(e, { useDraftCallback: o, clearDraftCallback: n } = {}) {
  const { CRUD: c, crud: u } = ed(), r = Ct({ key: e, expired: 6048e5, form: u.batchForm, initForm: void 0, init: void 0, isRegister: false, saveStoreForm: () => {
    const E = mS(r);
    return u.cancelBCU(), E;
  }, resetForm: () => {
    Y2(r), u.resetBatchForm(), r.init && r.init(), typeof n == "function" && n();
  } });
  return c.HOOK.afterToBatchAdd = () => B9(r, o), c.HOOK.beforeBatchAddCancel = () => Nd(r), c.HOOK.afterBatchAddSuccess = () => {
    Y2(r), Nd(r);
  }, bl(() => {
    K2(r, u), Nd(r);
  }), window.onbeforeunload = () => {
    K2(r, u);
  }, yi("bfmStore", r), r;
}
function z9(e) {
  e.initForm = void 0;
}
function B9(e, o) {
  const n = q9(e.key);
  if (Ae(n)) e.init && e.init();
  else {
    const c = n.content;
    H9(e.form, c), typeof o == "function" && o(e.form);
  }
  e.initForm = uo.cloneDeep(e.form), e.isRegister = true;
}
function Nd(e) {
  e.isRegister = false, z9(e);
}
function H9(e, o) {
  for (const n in e) e[n] = void 0;
  for (const n in o) e[n] = o[n];
}
