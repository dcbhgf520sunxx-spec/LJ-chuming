const F1 = { NOT: { L: "未排期", K: "NOT", V: 1 }, PART: { L: "部分排期", K: "PART", V: 2 }, COMPLETED: { L: "排期完毕", K: "COMPLETED", V: 4 } };
ve(F1);
const z1 = { ONE: { L: "最近一个月交货", K: "ONE", V: 1 }, TWO: { L: "最近二个月交货", K: "TWO", V: 2 }, THREE: { L: "最近三个月交货", K: "THREE", V: 3 }, SIX: { L: "最近半年交货", K: "SIX", V: 6 }, TWELVE: { L: "最近一年交货", K: "TWELVE", V: 12 } };
ve(z1);
const vI = { changeRecordStatusEnum: Y1, manufactureTypeEnum: K1, processingColorsEnum: W1, scheduleStatusEnum: F1, monthNumEnum: z1, destinationTypeEnum: Bt, problemTypeEnum: j1, constructionSiteAndFactoryEnum: Oc }, bw = Object.freeze(Object.defineProperty({ __proto__: null, changeRecordStatusEnum: Y1, constructionSiteAndFactoryEnum: Oc, default: vI, destinationTypeEnum: Bt, manufactureTypeEnum: K1, monthNumEnum: z1, problemTypeEnum: j1, processingColorsEnum: W1, scheduleStatusEnum: F1 }, Symbol.toStringTag, { value: "Module" })), B1 = { REQUISITIONS_APPROVAL: { L: "申购审批", K: "CONTRACT_REVIEW", V: 1 } };
ve(B1);
const H1 = { START: { L: "发起审批", K: "START", V: 0, COLOR: "#1890ff" }, NEW: { L: "未启动", K: "NEW", V: 1, COLOR: "#1890ff" }, RUNNING: { L: "处理中", K: "RUNNING", V: 2, COLOR: "#1890ff" }, PAUSED: { L: "暂停", K: "PAUSED", V: 3, COLOR: "#909399" }, COMPLETED: { L: "完成", K: "COMPLETED", V: 4, COLOR: "#13ce66" }, CANCELED: { L: "取消", K: "CANCELED", V: 5, COLOR: "#FFBA00" }, TERMINATED: { L: "被终止", K: "TERMINATED", V: 6, COLOR: "#ff4949" } };
ve(H1);
const rr = { UNREVIEWED: { L: "待审核", K: "UNREVIEWED", V: 1, TAG: "primary" }, AUDITING: { L: "审核中", K: "AUDITING", V: 16, TAG: "warning" }, PASS: { L: "已通过", K: "PASS", V: 2, TAG: "success" }, REFUSE: { L: "已拒绝", K: "REFUSE", V: 4, TAG: "danger" }, CANCEL: { L: "已撤销", K: "CANCEL", V: 8, TAG: "danger" } };
ve(rr);
const Lt = { UNREVIEWED: { L: "待审核", K: "UNREVIEWED", V: 1, TAG: "primary" }, AUDITING: { L: "审核中", K: "AUDITING", V: 16, TAG: "warning" }, PASS: { L: "已通过", K: "PASS", V: 2, TAG: "success" }, REFUSE: { L: "已拒绝", K: "REFUSE", V: 4, TAG: "danger" }, CANCEL: { L: "已撤销", K: "CANCEL", V: 8, TAG: "danger" } };
ve(Lt);
const q1 = { START: { L: "开始", K: "START", V: 1 }, FINISH: { L: "结束", K: "FINISH", V: 2 }, START_FINISH: { L: "开始和结束", K: "START_FINISH", V: 3 } };
ve(q1);
const G1 = { AND: { L: "会签", K: "AND", V: 1 }, OR: { L: "或签", K: "OR", V: 2 }, NONE: { L: "单人", K: "NONE", V: 3 } };
ve(G1);
const Q1 = { DEPT: { L: "部门", K: "DEPT", V: 1 }, USER: { L: "用户", K: "USER", V: 2 } };
ve(Q1);
const rl = { UNDER_APPROVAL: { L: "审批中", K: "UNDER_APPROVAL", V: 1, T: "primary" }, PASSED: { L: "已通过", K: "PASSED", V: 2, T: "success" }, INVALID: { L: "作废中", K: "INVALID", V: 3, T: "warning" }, VOIDED: { L: "已作废", K: "VOIDED", V: 4, T: "danger" } };
ve(rl);
const ws = { UNDER_APPROVAL: { L: "通过", K: "UNDER_APPROVAL", V: 2 }, REJECT: { L: "驳回", K: "REJECT", V: 4 }, PASSED: { L: "撤销", K: "PASSED", V: 8 }, WITHDRAW: { L: "审核中", K: "WITHDRAW", V: 16 }, UNEXPECTED_INTERRUPTION: { L: "意外中断", K: "UNEXPECTED_INTERRUPTION", V: 32 } };
ve(ws);
const RI = { ddApproveTypeEnum: B1, ddReviewStatusEnum: rr, ddApprovalPositionEnum: q1, ddTaskActionTypeEnum: G1, ddApprovalProcessStatusEnum: H1, ddUserTypeEnum: Q1, approvalEnum: rl, approvalListEnum: ws }, Vw = Object.freeze(Object.defineProperty({ __proto__: null, approvalEnum: rl, approvalListEnum: ws, ddApprovalPositionEnum: q1, ddApprovalProcessStatusEnum: H1, ddApproveTypeEnum: B1, ddReviewStatusEnum: rr, ddReviewStatusV2Enum: Lt, ddTaskActionTypeEnum: G1, ddUserTypeEnum: Q1, default: RI }, Symbol.toStringTag, { value: "Module" }));
function St(e, o, n, c = 10, { showUnit: u = false, toNum: r = true } = {}) {
  if (e == null || isNaN(+e) || !o || !n) return e;
  const E = N2(n), y = N2(o);
  return e = R6(+e).from(y).to(E), e = e.toFixed(c), r && (e = +e), u && (e += ` ${n}`), e;
}
function N2(e) {
  switch (e) {
    case "L":
      return "l";
    case "dL":
      return "dl";
    case "cL":
      return "cl";
    case "㎏":
      return "kg";
    case "㎝":
      return "cm";
    case "㎜":
      return "mm";
    case "t":
      return "mt";
    case "mm²":
      return "mm2";
    case "cm²":
      return "cm2";
    case "㎡":
    case "m²":
      return "m2";
    case "km²":
      return "km2";
    case "sq.in":
      return "in2";
    case "sq.ft":
      return "ft2";
    case "sq.mi":
      return "mi2";
    case "mm³":
      return "mm3";
    case "cm³":
      return "cm3";
    case "m³":
      return "m3";
    case "km³":
      return "km3";
    case "cu in":
      return "in3";
    case "cu ft":
      return "ft3";
    case "tcu yd":
      return "yd3";
    default:
      return e;
  }
}
async function ti(e, o) {
  const c = (await ww()).get(e);
  return !(!c || o !== c.name && o !== c.symbol);
}
async function ww(e = 1) {
  try {
    return _e.state.config.loaded.unit || await _e.dispatch("config/fetchUnit"), _e.state.config.unit.MAP;
  } catch {
    if (e && e <= 10) return await Vs(1e3), await ww(++e);
    throw new Error("加载单位失败");
  }
}
function To(e, o) {
  const n = Sw(e, 10);
  return Math.floor(n * 36e3 * (o || 1));
}
function hst(e, o, n = 2) {
  const c = Sw(e, n + 1);
  return St(c, "mm", o, n);
}
function ta(e, o, n = 2) {
  const c = St(e, o, "mm", n + 1);
  return MI(c, n);
}
function Sw(e, o = 2) {
  const n = Z1(), c = e * 25.4 / n[0];
  return parseFloat(c.toFixed(o));
}
function MI(e, o = 2) {
  var n = Z1(), c = parseFloat(e) / 25.4 * n[0];
  return parseFloat(c.toFixed(o));
}
function ul(e, o = 2) {
  var n = Z1(), c = parseFloat(e) / 96 * n[0];
  return parseFloat(c.toFixed(o));
}
function Z1() {
  var e = [];
  if (window.screen.deviceXDPI !== void 0) e[0] = window.screen.deviceXDPI, e[1] = window.screen.deviceYDPI;
  else {
    var o = document.createElement("DIV");
    o.style.cssText = "width:1in;height:1in;position:absolute;left:0px;top:0px;z-index:99;visibility:hidden", document.body.appendChild(o), e[0] = parseInt(o.offsetWidth), e[1] = parseInt(o.offsetHeight), o.parentNode.removeChild(o);
  }
  return e;
}
function vw(e = []) {
  const o = [];
  return e.forEach((n) => {
    if (A(n.children)) {
      const c = vw(n.children);
      A(c) && o.push.apply(o, c);
    } else o.push(n);
  }), o;
}
function Rw(e = []) {
  const o = [];
  return e.forEach((n) => {
    if (o.push(n), A(n.children)) {
      const c = Rw(n.children);
      A(c) && o.push.apply(o, c);
    }
  }), o;
}
function AI(e, o, n = "id", c = "children") {
  let u;
  if (typeof o == "string" || typeof o == "number" ? u = [o] : Array.isArray(o) && (u = [...o]), !(e instanceof Array && e.length > 0 && u && u.length > 0 && n && c)) return [];
  const E = [];
  return u.forEach((y) => {
    Mw(e, y, n, c) && E.push(y);
  }), E;
}
function Mw(e, o, n = "id", c = "children") {
  if (!(!e || e.length === 0)) for (const u of e) {
    if (u[n] === o) return o;
    const r = u[c];
    if (r && r.length > 0 && Mw(r, o, n, c)) return o;
  }
}
function zr(e, o = "children") {
  e && e.length > 0 && e.forEach((n) => {
    n[o] && (n[o].length < 1 ? n[o] = void 0 : zr(n[o], o));
  });
}
function NI(e) {
  var o = [], n = function(c) {
    c && c.length > 0 && (o.push(c[0]), c[0].children && n(c[0].children));
  };
  return n(e), o;
}
function Aw(e) {
  const o = [];
  return Array.isArray(e) && e.forEach((n) => {
    if (n.children) {
      const c = Aw(n.children);
      return o.push.apply(o, c);
    } else o.push(n.id);
  }), o;
}
function Nw(e, o) {
  return !Array.isArray(e) || !Array.isArray(o) ? [] : e.filter((n) => {
    const c = o.includes(n.id);
    if (c && n.children) {
      const u = Nw(n.children, o);
      n.children = A(u) ? u : void 0;
    }
    return c;
  });
}
function Uo(e, o = "id") {
  const n = {};
  for (const c of e) n[c[o]] = c;
  return n;
}
function Ps(e) {
  const o = [];
  for (const n in e) e[n] && o.push(e[n]);
  return o;
}
function L2(e, o, n = 1) {
  return Lw(e, o, n = 1);
}
function Lw(e, o, n = 1) {
  return e == null ? void 0 : e.map((c) => {
    const u = { parent: o, id: c.id, name: c.name, code: c.code, boolStatus: c.boolStatus, serialNumber: `${A(o) ? o.serialNumber : ""}${c.code}` };
    return n === 1 ? (u.fullPathId = [c.id], u.fullPathName = [c.name], u.basicClass = c.basicClass, u.basicClassName = Xo.VL[c.basicClass]) : (u.fullPathId = [...o.fullPathId, c.id], u.fullPathName = [...o.fullPathName, c.name], u.basicClass = o.basicClass, u.basicClassName = o.basicClassName), A(c.children) ? (u.children = Lw(c.children, u, n + 1), u.isLeaf = false) : u.isLeaf = true, u;
  });
}
function fst(e) {
  return Iw(e);
}
function Iw(e) {
  for (let o = 0; o < e.length; o++) return A(e[o].children) ? Iw(e[o].children) : e[o];
}
function LI(e) {
  return W({ module: "plan", url: "monomer", method: "get", params: e });
}
function II(e) {
  return W({ module: "plan", url: "monomer", method: "post", data: e });
}
