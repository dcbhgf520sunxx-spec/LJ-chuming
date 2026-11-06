const Xht = { get: BU, detail: A_ };
function GU(e) {
  return W({ module: "wms", url: `return/manufactured/application/record/${e}`, method: "get" });
}
function QU(e) {
  return W({ module: "wms", url: "reject/application/review/raw-materials", method: "get", params: e });
}
function N_(e) {
  return W({ module: "wms", url: `reject/application/review/raw-materials/${e}`, method: "get" });
}
function $ht(e) {
  return W({ module: "wms", url: "reject/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function eft(e) {
  return W({ module: "wms", url: "reject/application/review/raw-materials/returned", headers: { "Content-Type": "application/x-www-form-urlencoded" }, method: "put", data: e });
}
function tft(e) {
  return W({ url: "/api/v2/wms/reject/application/review/raw-materials/passed", headers: { "Content-Type": "application/x-www-form-urlencoded" }, method: "put", data: e });
}
function ZU(e) {
  return W({ url: `/api/v2/wms/reject/revocation/${e.id}`, method: "post" });
}
function JU(e) {
  return W({ url: "/api/v2/wms/reject/review", method: "put", params: e });
}
const ift = { get: QU, detail: N_ };
function aft(e) {
  return W({ module: "wms", url: "report/raw-materials/supplement/details", method: "get", params: e });
}
function XU(e) {
  return W({ module: "wms", url: `report/raw-materials/supplement/${e}`, method: "get" });
}
function $U(e) {
  return W({ module: "wms", url: "convert/convert", method: "get", params: e });
}
function sv(e) {
  return W({ module: "wms", url: `convert/convertDetail/${e}`, method: "get", cancelKey: false });
}
function lft(e) {
  return W({ module: "wms", url: `convert/convertDetail/${e}`, method: "get", cancelKey: false });
}
function oft(e) {
  return W({ module: "wms", url: `convert/convertReturn/${e}`, method: "get" });
}
function nft(e) {
  return W({ module: "wms", url: `convert/passed/${e}`, method: "get" });
}
function sft(e) {
  return W({ module: "wms", url: "convert/reviewedNum", method: "get" });
}
function rft(e) {
  return W({ module: "wms", url: "convert/getProjectConvert", method: "get", params: e });
}
function rv(e) {
  return W({ module: "wms", url: "convert/convertDetailExport", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
const uft = { get: $U, detail: sv };
function eY(e) {
  return W({ module: "wms", url: "plant/convert/convert", method: "get", params: e });
}
function mm(e) {
  return W({ module: "wms", url: `plant/convert/convertDetail/${e}`, method: "get" });
}
const cft = { get: eY, detail: mm };
function uv(e, o) {
  return W({ url: "/api/v2/wms/inbound/application/review/selfBuying/approval", method: "post", params: e, data: o });
}
function ui({ rules: e = {}, ditto: o = /* @__PURE__ */ new Map(), errorMsg: n = "请修正表格中标红的信息" }) {
  return { tableValidate: (c) => tY(c, e, o, n), wrongCellMask: (c) => iY(c, e), cleanUpData: (c) => aY(c, o) };
}
function tY(e, o, n, c) {
  const u = I_(o);
  let r = true, E = "请填写数据";
  const y = _s(e), b = [];
  if (e && e.length > 0) {
    let V = true;
    for (const M in e) {
      const g = e[M];
      delete g.verify;
      const S = _s(g);
      if (delete S.uid, n.forEach((_, f) => {
        S[f] === _ && delete S[f];
      }), !Ps(S).some((_) => A(_))) {
        b.push(M);
        continue;
      }
      V && (n.forEach((_, f) => {
        g[f] === _ && delete g[f];
      }), V = false), g.verify = {};
      for (const _ in u) g.verify[_] = L_(_, u[_], g), g.verify[_] || (r = false);
    }
    r || (E = c), b.length === y.length && (r = false);
  } else r = false;
  return r || ot({ message: E, type: "error" }), { dealList: e, validResult: r };
}
function iY({ row: e, column: o }, n) {
  if (!e) return;
  const c = I_(n);
  let u = true;
  return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[o.property] === false && (u = L_(o.property, c[o.property], e)), u && (e.verify[o.property] = true)), u ? "" : "mask-td";
}
function L_(e, o, n = {}) {
  const c = mn(n, e);
  let u = true;
  if (Ae(o)) return u;
  let r = 0;
  for (r = 0; r < o.length; r++) {
    const E = o[r], y = E.pattern;
    if (y && !y.test(c || "")) {
      u = false;
      break;
    }
    const b = E.validator;
    if (typeof b == "function" && b(c, n) === false) {
      u = false;
      break;
    }
    if (E.required === true && Ae(c)) {
      u = false;
      break;
    }
    const M = E.type;
    if (M && typeof c !== M) {
      u = false;
      break;
    }
    const g = E.max, S = E.min;
    if (typeof c == "string" && (S && S !== 0 && c.length < S || g && g !== 0 && g < c.length)) {
      u = false;
      break;
    }
  }
  return u || console.error(`${e}：${o[r].message}`), u;
}
function aY(e, o = /* @__PURE__ */ new Map()) {
  const n = _s(e);
  e.length = 0, n.forEach((u, r) => {
    o.forEach((b, V) => {
      u[V] === b && delete u[V];
    }), delete u.uid, Ps(u).some((b) => A(b)) && e.push(u);
  });
  const c = /* @__PURE__ */ new Map();
  return e.forEach((u) => {
    delete u.verify;
    const r = [];
    for (const E in u) r.push(E);
    o.forEach((E, y) => {
      Ae(u[y]) ? !r.includes(y) && !u["origin_" + y] && (u[y] = c.get(y)) : c.set(y, u[y]);
    });
  }), e;
}
function gi(e, o) {
  if (!e) return true;
  const n = I_(o);
  try {
    for (const c of e) for (const u in n) if (!lY(u, n[u], c)) break;
  } catch (c) {
    return ot.error({ message: c.message, duration: 3e3 }), false;
  }
  return true;
}
function lY(e, o, n = {}) {
  const c = mn(n, e);
  let u = true;
  if (Ae(o)) return u;
  let r = 0;
  for (r = 0; r < o.length; r++) {
    const E = o[r], y = E.pattern;
    if (y && !y.test(c || "")) {
      u = false;
      break;
    }
    const b = E.validator;
    if (typeof b == "function" && b(c, n) === false) {
      u = false;
      break;
    }
    if (E.required === true && Ae(c)) {
      u = false;
      break;
    }
    const M = E.type;
    if (M && typeof c !== M) {
      u = false;
      break;
    }
    const g = E.max, S = E.min;
    if (typeof c == "string" && (S && S !== 0 && c.length < S || g && g !== 0 && g < c.length)) {
      u = false;
      break;
    }
  }
  if (!u) throw console.error(`${e}：${o[r].message}`), new Error(`${o[r].message}`);
  return u;
}
function I_(e) {
  let o;
  switch (e.constructor.name) {
    case "EL":
    case "RefImpl":
    case "ComputedRefImpl":
      o = e.value;
      break;
    default:
      o = e;
      break;
  }
  return o;
}
function dft(e, o, n = {}) {
  const c = mn(n, e);
  let u = true, r = "";
  if (Ae(o)) return { valid: true };
  let E = 0;
  for (E = 0; E < o.length; E++) {
    const y = o[E], b = y.pattern;
    if (b && !b.test(c || "")) {
      u = false, r = y.message;
      break;
    }
    const V = y.validator;
    if (typeof V == "function") {
      const T = V(c, n);
      if (typeof T == "object") {
        if (!T.valid) {
          u = false, r = T.message;
          break;
        }
      } else if (T === false) {
        u = false, r = y.message;
        break;
      }
    }
    if (y.required === true && Ae(c)) {
      u = false, r = y.message;
      break;
    }
    const g = y.type;
    if (g && typeof c !== g) {
      u = false, r = y.message;
      break;
    }
    const S = y.max, h = y.min;
    if (typeof c == "string" && (h && h !== 0 && c.length < h || S && S !== 0 && S < c.length)) {
      u = false, r = y.message;
      break;
    }
  }
  return u || console.error(`${e}：${r}`), { valid: u, message: r };
}
const oY = { class: "table-expand-container" }, Ha = { __name: "el-expand-table-column", props: { data: { type: Array, default: () => [] }, rowKey: { type: [Function, String] }, expandRowKeys: { type: Array, default: () => [] } }, emits: ["update:expandRowKeys"], setup(e, { emit: o }) {
  const n = o, c = e, u = Ee(() => c.data.length !== 0 && c.expandRowKeys.length === c.data.length);
  function r() {
    u.value ? n("update:expandRowKeys", []) : n("update:expandRowKeys", c.data.map((y) => y[E()]));
  }
  function E(y) {
    if (typeof c.rowKey == "function") return c.rowKey(y);
    if (typeof c.rowKey == "string") return c.rowKey;
  }
  return (y, b) => {
    const V = xV, M = Km, g = ml, S = vt;
    return w(), U(S, { type: "expand" }, { header: p(() => [s(g, { class: "pointer", onClick: r }, { default: p(() => [u.value ? (w(), U(V, { key: 0 })) : (w(), U(M, { key: 1 }))]), _: 1 })]), default: p((h) => [C("div", oY, [xt(y.$slots, "default", { row: h.row })])]), _: 3 });
  };
} }, nY = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, _b = { __name: "raw-mat", props: { showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showOutboundWorkshop: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: true }, showWarehouse: { type: Boolean, default: true }, columns: { type: Object }, fixed: { type: String }, workshopLabel: { type: String, default: "出库车间" }, showAreaBatchName: { type: Boolean, default: false } }, setup(e) {
  const o = e, { workshopNameKV: n } = ES();
  function c(V) {
    var h;
    const M = V.workshop ? V.workshop.id : V.workshopId, g = (h = n.value[M]) == null ? void 0 : h.name, S = V.warehouse ? V.warehouse.name : V.warehouseName;
    return g ? g + "【" + S + "】" : S;
  }
  const u = Ee(() => o.showWarehouse && (Ae(o.columns) || o.columns.visible("warehouse"))), r = Ee(() => o.showProject && (Ae(o.columns) || o.columns.visible("project"))), E = Ee(() => o.showMonomer && (Ae(o.columns) || o.columns.visible("monomerName"))), y = Ee(() => o.showArea && (Ae(o.columns) || o.columns.visible("areaName"))), b = Ee(() => o.showOutboundWorkshop && (Ae(o.columns) || o.columns.visible("workshop")));
  return (V, M) => {
    const g = Ve("table-cell-tag"), S = vt, h = jt;
    return w(), Q(Qe, null, [r.value ? (w(), U(S, { key: "project", fixed: e.fixed, align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }, { default: p(({ row: T }) => {
      var _;
      return [e.showTransfer && T.outboundRelationType && T.outboundRelationType !== l(gl).ROUTINE.V ? (w(), U(g, { key: 0, name: (_ = l(gl).VL) == null ? void 0 : _[T.outboundRelationType], offset: 15, type: "transfer" }, null, 8, ["name"])) : H("", true), Te(" " + K(T.project), 1)];
    }), _: 1 }, 8, ["fixed"])) : H("", true), xt(V.$slots, "projectAfter"), r.value && e.showAreaBatchName ? (w(), U(S, { key: "areaBatchName", "show-overflow-tooltip": true, align: "left", label: "批次", "min-width": "100", prop: "areaBatchName" })) : H("", true), E.value ? (w(), U(S, { key: "monomerName", "show-overflow-tooltip": true, align: "left", label: "单体", "min-width": "100", prop: "monomerName" })) : H("", true), y.value ? (w(), U(S, { key: "areaName", "show-overflow-tooltip": true, align: "left", label: "区域", "min-width": "100", prop: "areaName" })) : H("", true), b.value ? (w(), U(S, { key: "mesWorkshop.name", label: e.workshopLabel, "show-overflow-tooltip": true, align: "left", "min-width": "100", prop: "mesWorkshop.name" }, { default: p(({ row: T }) => {
      var _;
      return [Te(K(((_ = T.mesWorkshop) == null ? void 0 : _.name) || "-"), 1)];
    }), _: 1 }, 8, ["label"])) : H("", true), u.value ? (w(), U(S, { key: "warehouse", fixed: e.fixed, align: "left", label: "仓库", "min-width": "130px", prop: "warehouse" }, { default: p(({ row: T }) => [C("div", nY, [o.showWorkshop ? (w(), U(Os, { key: 0, id: T.workshop ? T.workshop.id : T.workshopId }, null, 8, ["id"])) : H("", true), s(h, { class: "item", effect: "dark", content: c(T), placement: "top-start" }, { default: p(() => [C("span", null, K(T.warehouse ? T.warehouse.name : T.warehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 }, 8, ["fixed"])) : H("", true)], 64);
  };
} }, xl = { __name: "index", props: { basicClass: { type: Number }, showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: true }, showFactory: { type: Boolean, default: true }, showWarehouse: { type: Boolean, default: true }, columns: { type: Object }, workshopLabel: { type: String, default: "出库车间" }, showAreaBatchName: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return _b;
      default:
        return _b;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), ii({ columns: e.columns, "show-area": e.showArea, "show-monomer": e.showMonomer, "show-project": e.showProject, "show-transfer": e.showTransfer, "show-warehouse": e.showWarehouse, "show-workshop": e.showWorkshop, showAreaBatchName: e.showAreaBatchName }, c.$attrs), { projectAfter: p(() => [xt(c.$slots, "projectAfter")]), _: 3 }, 16, ["columns", "show-area", "show-monomer", "show-project", "show-transfer", "show-warehouse", "show-workshop", "showAreaBatchName"]));
} };
const sY = { class: "width-text" }, rY = { class: "length-text" }, uY = { __name: "steel-plate-square", props: { length: { type: [Number, String] }, width: { type: [Number, String] }, borderColor: { type: String, default: "#909399" }, color: { type: String, default: "#e6a23c" }, unit: { type: String, default: "mm" }, elHeight: { type: Number, default: 100 } }, setup(e) {
  const o = e, n = Ee(() => {
    let r = o.width;
    return +o.width > +o.length && (r = o.length), `${r}${o.unit}`;
  }), c = Ee(() => {
    let r = o.length;
    return +o.width > +o.length && (r = o.width), `${r}${o.unit}`;
  }), u = Ee(() => {
    const { width: r, length: E, elHeight: y, color: b, borderColor: V, unit: M } = o;
    if (!+r || !+E || !b || !y || !V || !M) return { display: "none" };
    {
      let g = +r, S = +E;
      g > S && (g = +E, S = +r);
      const h = S / g;
      return { color: b, height: `${y}px`, width: `${Math.floor(h * y)}px`, border: "1px solid", "border-color": V };
    }
  });
  return (r, E) => (w(), Q("div", { class: "steel-plate-square", style: ri(u.value) }, [C("span", sY, K(n.value), 1), C("span", rY, K(c.value), 1)], 4));
} }, cY = ut(uY, [["__scopeId", "data-v-b13c0ce1"]]);
const dY = { class: "flex-rbs" }, mY = { class: "info" }, pY = { key: 0 }, hY = { key: 1 }, fY = { key: 2 }, gY = { class: "square-content" }, EY = { key: 0 }, yY = ["href"], TY = ["src"], _Y = { __name: "steel-plate", props: { row: { type: Object, default: () => ({}) }, showRemark: { type: Boolean, default: false }, showBrand: { type: Boolean, default: false }, showBatchNo: { type: Boolean, default: true }, showGraphics: { type: Boolean, default: false } }, setup(e) {
  const o = e;
  return (n, c) => (w(), Q("div", dY, [C("div", mY, [e.showBrand ? (w(), Q("p", pY, [c[0] || (c[0] = Te(" 品牌：")), C("span", null, K(o.row.brand), 1)])) : H("", true), e.showBatchNo ? (w(), Q("p", hY, [c[1] || (c[1] = Te(" 炉批号：")), C("span", null, K(o.row.heatNoAndBatchNo), 1)])) : H("", true), e.showRemark ? (w(), Q("p", fY, [c[2] || (c[2] = Te(" 备注：")), C("span", null, K(o.row.remark), 1)])) : H("", true), xt(n.$slots, "default", {}, void 0, true)]), C("div", gY, [e.showGraphics ? (w(), Q("div", EY, [e.row.surplusGraphicsPath ? (w(), Q("a", { key: 0, download: "", target: "_blank", href: e.row.surplusGraphicsPath }, [C("img", { src: e.row.surplusGraphicsPath, style: { "max-height": "100px" } }, null, 8, TY)], 8, yY)) : (w(), U(cY, { key: 1, width: e.row.width, length: e.row.length }, null, 8, ["width", "length"]))])) : H("", true)])]));
} }, bY = ut(_Y, [["__scopeId", "data-v-80e6441e"]]), VY = { __name: "section-steel", props: { row: { type: Object, default: () => ({}) }, showRemark: { type: Boolean, default: false }, showBrand: { type: Boolean, default: false }, showBatchNo: { type: Boolean, default: true } }, setup(e) {
  const o = e;
  return (n, c) => (w(), Q(Qe, null, [e.showBrand ? (w(), Q("p", Ol(ii({ key: 0 }, n.$attrs)), [c[0] || (c[0] = Te(" 品牌：")), C("span", null, K(o.row.brand), 1)], 16)) : H("", true), e.showBatchNo ? (w(), Q("p", Ol(ii({ key: 1 }, n.$attrs)), [c[1] || (c[1] = Te(" 炉批号：")), C("span", null, K(o.row.heatNoAndBatchNo), 1)], 16)) : H("", true), e.showRemark ? (w(), Q("p", Ol(ii({ key: 2 }, n.$attrs)), [c[2] || (c[2] = Te(" 备注：")), C("span", null, K(o.row.remark), 1)], 16)) : H("", true), xt(n.$slots, "default", Ol(bc(n.$attrs)))], 64));
} }, wY = { __name: "steel-coil", props: { row: { type: Object, default: () => ({}) }, showRemark: { type: Boolean, default: false }, showBrand: { type: Boolean, default: false }, showBatchNo: { type: Boolean, default: true } }, setup(e) {
  const o = e;
  return (n, c) => (w(), Q(Qe, null, [e.showBrand ? (w(), Q("p", Ol(ii({ key: 0 }, n.$attrs)), [c[0] || (c[0] = Te(" 品牌：")), C("span", null, K(o.row.brand), 1)], 16)) : H("", true), e.showBatchNo ? (w(), Q("p", Ol(ii({ key: 1 }, n.$attrs)), [c[1] || (c[1] = Te(" 卷号：")), C("span", null, K(o.row.heatNoAndBatchNo), 1)], 16)) : H("", true), e.showRemark ? (w(), Q("p", Ol(ii({ key: 2 }, n.$attrs)), [c[2] || (c[2] = Te(" 备注：")), C("span", null, K(o.row.remark), 1)], 16)) : H("", true), xt(n.$slots, "default", Ol(bc(n.$attrs)))], 64));
} }, bb = { __name: "aux-mat", props: { row: { type: Object, default: () => ({}) }, showRemark: { type: Boolean, default: false }, showBrand: { type: Boolean, default: false } }, setup(e) {
  const o = e;
  return (n, c) => (w(), Q(Qe, null, [e.showBrand ? (w(), Q("p", Ol(ii({ key: 0 }, n.$attrs)), [c[0] || (c[0] = Te(" 品牌：")), C("span", null, K(o.row.brand), 1)], 16)) : H("", true), e.showRemark ? (w(), Q("p", Ol(ii({ key: 1 }, n.$attrs)), [c[1] || (c[1] = Te(" 备注：")), C("span", null, K(o.row.remark), 1)], 16)) : H("", true), xt(n.$slots, "default", Ol(bc(n.$attrs)))], 64));
} }, SY = { __name: "gas", props: { row: { type: Object, default: () => ({}) }, showRemark: { type: Boolean, default: false }, showBrand: { type: Boolean, default: false } }, setup(e) {
  const o = e;
  return (n, c) => (w(), Q(Qe, null, [e.showBrand ? (w(), Q("p", Ol(ii({ key: 0 }, n.$attrs)), [c[0] || (c[0] = Te(" 品牌：")), C("span", null, K(o.row.brand), 1)], 16)) : H("", true), e.showRemark ? (w(), Q("p", Ol(ii({ key: 1 }, n.$attrs)), [c[1] || (c[1] = Te(" 备注：")), C("span", null, K(o.row.remark), 1)], 16)) : H("", true), xt(n.$slots, "default", Ol(bc(n.$attrs)))], 64));
} }, Xl = { __name: "index", props: { basicClass: { type: Number }, row: { type: Object, default: () => ({}) }, showBrand: { type: Boolean, default: false }, showRemark: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
        return bY;
      case dt.SECTION_STEEL.V:
        return VY;
      case dt.STEEL_COIL.V:
        return wY;
      case dt.MATERIAL.V:
        return bb;
      case dt.GAS.V:
        return SY;
      default:
        return bb;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { row: e.row, "show-remark": e.showRemark, "show-brand": e.showBrand }, { default: p(() => [xt(c.$slots, "default")]), _: 3 }, 8, ["row", "show-remark", "show-brand"]));
} };
const vY = { __name: "title-after-info", props: { order: { type: Object, default: () => ({}) }, detail: { type: Object, default: () => ({}) } }, setup(e) {
  return (o, n) => {
    const c = wi, u = _t("parse-enum");
    return w(), Q(Qe, null, [e.detail.licensePlate ? (w(), U(c, { key: 0, effect: "plain" }, { default: p(() => [Te(K(`车牌：${e.detail.licensePlate}`), 1)]), _: 1 })) : H("", true), e.detail.shipmentNumber ? (w(), U(c, { key: 1, effect: "plain" }, { default: p(() => [Te(K(`物流单号：${e.detail.shipmentNumber}`), 1)]), _: 1 })) : H("", true), e.order.supplyType ? qe((w(), U(c, { key: 2, type: "info", effect: "plain" }, null, 512)), [[u, { e: l(Ni), v: e.order.supplyType }]]) : H("", true), e.order.weightMeasurementMode ? qe((w(), U(c, { key: 3, type: "info", effect: "plain" }, null, 512)), [[u, { e: l(Wt), v: e.order.weightMeasurementMode }]]) : H("", true), e.order.purchaseOrderPaymentMode ? qe((w(), U(c, { key: 4, type: "info", effect: "plain" }, null, 512)), [[u, { e: l(Jl), v: e.order.purchaseOrderPaymentMode }]]) : H("", true)], 64);
  };
} }, C_ = ut(vY, [["__scopeId", "data-v-07cab530"]]), RY = Object.freeze(Object.defineProperty({ __proto__: null, default: C_ }, Symbol.toStringTag, { value: "Module" })), Vb = { __name: "raw-mat", props: { columns: { type: Object }, showUnitPriceE: { type: Boolean, default: false }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showInputVAT: { type: Boolean, default: true }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true } }, setup(e) {
  const o = e, n = Ee(() => o.showInvoiceType && (Ae(o.columns) || o.columns.visible("invoiceType"))), c = Ee(() => o.showTaxRate && (Ae(o.columns) || o.columns.visible("taxRate"))), u = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("unitPrice"))), r = Ee(() => o.showAmountExcludingVAT && o.showUnitPriceE && (Ae(o.columns) || o.columns.visible("unitPriceExcludingVAT"))), E = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("amount"))), y = Ee(() => o.showAmountExcludingVAT && (Ae(o.columns) || o.columns.visible("amountExcludingVAT"))), b = Ee(() => o.showInputVAT && (Ae(o.columns) || o.columns.visible("inputVAT")));
  return (V, M) => {
    const g = vt;
    return w(), Q(Qe, null, [n.value ? (w(), U(g, { key: "invoiceType", align: "center", label: "票据类型", "min-width": "70px", prop: "invoiceType", "show-overflow-tooltip": "" })) : H("", true), c.value ? (w(), U(g, { key: "taxRate", align: "center", label: "税率", "min-width": "70", prop: "taxRate", "show-overflow-tooltip": "" })) : H("", true), u.value ? (w(), U(g, { key: "unitPrice", align: "right", label: `含税单价
(含运费装车费)`, "min-width": "150px", prop: "unitPrice", "show-overflow-tooltip": "" })) : H("", true), E.value ? (w(), U(g, { key: "amount", align: "right", label: `含税金额
(含运费装车费)`, "min-width": "105px", prop: "amount", "show-overflow-tooltip": "" })) : H("", true), r.value ? (w(), U(g, { key: "unitPriceExcludingVAT", align: "right", label: `不含税单价
(含运费装车费)`, "min-width": "150px", prop: "unitPriceExcludingVAT", "show-overflow-tooltip": "" })) : H("", true), y.value ? (w(), U(g, { key: "amountExcludingVAT", align: "right", label: `不含税金额
(含运费装车费)`, "min-width": "105px", prop: "amountExcludingVAT", "show-overflow-tooltip": "" })) : H("", true), b.value ? (w(), U(g, { key: "inputVAT", align: "right", label: `进项税
(含运费装车费)`, "min-width": "105px", prop: "inputVAT", "show-overflow-tooltip": "" })) : H("", true)], 64);
  };
} }, cv = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return Vb;
      default:
        return Vb;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { columns: e.columns, "show-invoice-type": e.showInvoiceType, "show-tax-rate": e.showTaxRate, "show-amount": e.showAmount, "show-amount-excluding-v-a-t": e.showAmountExcludingVAT }, null, 8, ["columns", "show-invoice-type", "show-tax-rate", "show-amount", "show-amount-excluding-v-a-t"]));
} }, Ln = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.decimalPrecision);
  if (n.value || o.dispatch("config/fetchAllDecimal"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { decimalPrecision: Ee(() => o.state.config.decimalPrecision), loaded: n };
};
const MY = { __name: "inspection-return-info", props: { basicClass: { type: Number }, list: { type: Array, default: () => [] }, showTableColumnSecondary: { type: Boolean }, showAmount: { type: Boolean }, boolPartyA: { type: Boolean } }, setup(e) {
  const { decimalPrecision: o } = Ln(), n = Z(), c = Z(), u = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", o.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", o.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"]]), { maxHeight: r } = Kt({ mainBox: ".wms-inspection-return-list", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, n);
  function E() {
    n.value = true;
  }
  return (y, b) => {
    const V = vt, M = Ve("common-table"), g = Ve("common-dialog");
    return w(), Q(Qe, null, [C("span", ii(y.$attrs, { class: "tip", onClick: E }), " * 当前入库单据存在质检退回物料，点击可查看质检退回的物料信息 ", 16), s(g, { title: "质检退回物料列表", modelValue: n.value, "onUpdate:modelValue": b[1] || (b[1] = (S) => n.value = S), width: "95%", "show-close": true, "custom-class": "wms-inspection-return-list", top: "10vh" }, { default: p(() => [s(M, { ref: "tableRef", data: e.list, "data-format": u.value, "max-height": l(r), "default-expand-all": false, "expand-row-keys": c.value, "row-key": "id" }, { default: p(() => [s(Ha, { data: e.list, "expand-row-keys": c.value, "onUpdate:expandRowKeys": b[0] || (b[0] = (S) => c.value = S), "row-key": "id", fixed: "left" }, { default: p(({ row: S }) => [e.showTableColumnSecondary ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": e.basicClass, row: S, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [b[2] || (b[2] = Te(" 备注：")), C("span", null, K(S.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(fa, { "basic-class": e.basicClass, fixed: "left" }, null, 8, ["basic-class"]), s(za, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), e.showTableColumnSecondary ? (w(), U(Ba, { key: 0, "basic-class": e.basicClass }, null, 8, ["basic-class"])) : H("", true), e.showAmount ? (w(), Q(Qe, { key: 1 }, [e.boolPartyA ? H("", true) : (w(), U(cv, { key: 0 }))], 64)) : H("", true), s(V, { prop: "requisitionsSN", label: "申购单", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), s(xl, { "show-project": "" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, P_ = ut(MY, [["__scopeId", "data-v-6212ad23"]]), AY = Object.freeze(Object.defineProperty({ __proto__: null, default: P_ }, Symbol.toStringTag, { value: "Module" })), NY = { key: 0, class: "purchase-detail-button" }, br = { __name: "index", props: { purchaseId: { type: Number }, btnName: { type: String, default: "采购合同详情" } }, setup(e) {
  const o = e, { detailRef: n, openDetail: c } = hl();
  return (u, r) => {
    const E = Ve("common-button");
    return l(Ai)(l(tn)) && e.purchaseId ? (w(), Q("span", NY, [s(E, ii(u.$attrs, { onClick: r[0] || (r[0] = (y) => l(c)(o.purchaseId)), type: "info" }), { default: p(() => [Te(K(o.btnName), 1)]), _: 1 }, 16), s(ol, { ref_key: "purchaseOrderRef", ref: n, api: l(Tr) }, { default: p(() => [s(ks, { showBtn: false })]), _: 1 }, 8, ["api"])])) : H("", true);
  };
} }, hu = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.suppliers);
  if (n.value || o.dispatch("config/fetchSuppliers"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: n, suppliers: Ee(() => o.state.config.suppliers), supplierKV: Ee(() => o.state.config.supplierKV) };
};
function LY(e) {
  return W({ module: "scm", url: "supplier", method: "get", params: e });
}
function IY(e) {
  return W({ module: "scm", url: `supplier/${e}`, method: "get" });
}
function CY(e) {
  return W({ module: "scm", url: "supplier", method: "post", data: e });
}
function PY(e) {
  return W({ module: "scm", url: "supplier", method: "put", data: e });
}
function O_(e) {
  return W({ module: "scm", url: "supplier/batch", method: "post", data: e });
}
function mft(e) {
  return W({ module: "scm", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "supplier/enabled", cancelKey: false, method: "put", data: e });
}
function OY(e) {
  return W({ module: "scm", url: "supplier", method: "delete", data: e });
}
function pft() {
  return W({ url: "/api/scm/supplier/template/export", method: "get", responseType: "blob", timeout: 6e7 });
}
function hft(e) {
  return W({ url: "api/scm/supplier/supplier/import", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, responseType: "blob", data: e });
}
function fft(e) {
  return W({ url: "api/scm/supplier/supplierExcel", method: "get", timeout: 6e6, responseType: "blob", params: e });
}
const gft = { get: LY, add: CY, detail: IY, edit: PY, batchAdd: O_, del: OY }, kY = { style: { "text-align": "right" } }, DY = { __name: "add-supplier", emits: ["close"], setup(e, { emit: o }) {
  const n = o, c = Ht(), u = Z(), r = Z(false), E = { name: "", socialCode: "", supplierClass: wn.LOGISTICS.V, supplierClassification: wn.LOGISTICS.V }, y = Z({ ...E }), b = { name: [{ required: true, message: "请输入供应商名称", trigger: "blur" }, { min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], supplierClass: [{ required: true, message: "请选择供应商分类", trigger: "blur" }] };
  function V() {
    y.value = { ...E };
  }
  async function M() {
    const S = await u.value.validate();
    try {
      S && (r.value = true, await O_([{ ...y.value }]), g(), V(), Di({ title: "新增成功", type: "success" }), c.dispatch("config/fetchSuppliers"));
    } catch (h) {
      console.log("新增供应商", h);
    } finally {
      r.value = false;
    }
  }
  function g() {
    n("close");
  }
  return (S, h) => {
    const T = Mt, _ = Zi, f = Ve("common-button"), m = Li;
    return w(), U(m, { ref_key: "formRef", ref: u, model: y.value, rules: b, size: "default", "label-width": "100px" }, { default: p(() => [s(_, { label: "物流单位", prop: "name" }, { default: p(() => [s(T, { modelValue: y.value.name, "onUpdate:modelValue": h[0] || (h[0] = (R) => y.value.name = R), maxlength: "32", "show-word-limit": "", placeholder: "请输入供应商名称" }, null, 8, ["modelValue"])]), _: 1 }), s(_, { label: "社会统一代码", prop: "socialCode" }, { default: p(() => [s(T, { modelValue: y.value.socialCode, "onUpdate:modelValue": h[1] || (h[1] = (R) => y.value.socialCode = R), placeholder: "请输入社会统一代码", maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), C("div", kY, [s(f, { loading: r.value, type: "primary", size: "default", onClick: M }, { default: p(() => h[2] || (h[2] = [Te("提 交")])), _: 1, __: [2] }, 8, ["loading"]), s(f, { size: "default", onClick: g }, { default: p(() => h[3] || (h[3] = [Te("关闭")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"]);
  };
} };
