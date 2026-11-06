import { computed as d } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as m } from "vue";
import { createBlock as n } from "vue";
import { withCtx as i } from "vue";
import { createVNode as S } from "vue";
import { unref as a } from "vue";
import { createElementVNode as M } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as w } from "vue";
import { createTextVNode as B } from "vue";
import { ElTooltip as _ } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ref as F } from "vue";
import { resolveComponent as K } from "vue";
import { renderSlot as X } from "vue";
import { normalizeClass as ie } from "vue";
import { mergeProps as ce } from "vue";
import { resolveDynamicComponent as ue } from "vue";
import { bl as r, i as p, rJ as fe, sQ as G, b as v, pz as A, pA as R, _ as re, cV as de, G as pe, BZ as he, o as me, zn as ee, xY as D, zF as U, yQ as W, xl as H, y7 as be, AI as ye } from "../shared/runtime.js";
function z(e) {
  switch (e.basicClass) {
    case r.STEEL_PLATE.V:
      return xe(e);
    case r.SECTION_STEEL.V:
      return ge(e);
    case r.STEEL_COIL.V:
      return ve(e);
    case r.MATERIAL.V:
      return we(e);
    case r.OTHER.V:
      return ke(e);
    case r.GAS.V:
      return Se();
    default:
      return "";
  }
}
function $(e) {
  let t = "";
  switch (e.basicClass) {
    case r.STEEL_PLATE.V:
      t = Oe(e);
      break;
    case r.SECTION_STEEL.V:
      t = Te(e);
      break;
    case r.STEEL_COIL.V:
      t = Le(e);
      break;
    case r.MATERIAL.V:
      t = Me(e);
      break;
    case r.OTHER.V:
      t = Ce(e);
      break;
    case r.GAS.V:
      t = Ee();
      break;
    default:
      t = "";
      break;
  }
  return t;
}
function xe(e) {
  const t = [];
  return p(e.thickness) && t.push(e.thickness), p(e.width) && t.push(e.width), p(e.length) && t.push(e.length), t.join("*");
}
function ge(e) {
  const t = [];
  return p(e.standard) && t.push(e.standard), p(e.length) && t.push(e.length), t.join(" * ");
}
function ve(e) {
  const t = [], c = [];
  return p(e.thickness) && c.push(e.thickness), p(e.width) && c.push(e.width), p(e.length) && c.push(e.length), p(c) && t.push(c.join("*")), p(e.color) && t.push(e.color), t.join(" * ");
}
function we(e) {
  const t = [];
  return p(e.color) && t.push(e.color), t.join(" * ");
}
function ke(e) {
  const t = [];
  return p(e.color) && t.push(e.color), t.join(" * ");
}
function Se(e) {
  return "";
}
function Oe(e) {
  const t = [];
  return p(e.thickness) && t.push("厚(mm)"), p(e.width) && t.push("宽(mm)"), p(e.length) && t.push("长(mm)"), t.join("*");
}
function Te(e) {
  const t = [];
  if (p(e.standard)) {
    const c = e.nationalStandard ? e.nationalStandard : "标准";
    t.push(c);
  }
  return p(e.length) && t.push("长(mm)"), t.join(" * ");
}
function Le(e) {
  const t = fe[r.STEEL_COIL.V], c = [], u = [];
  return p(e.thickness) && u.push("厚(mm)"), p(e.width) && u.push("宽(mm)"), p(e.length) && u.push(`长(${t.length.unit})`), p(u) && c.push(u.join("*")), p(e.color) && c.push("颜色"), c.join(" * ");
}
function Me(e) {
  const t = [];
  return p(e.color) && t.push("颜色"), t.join(" * ");
}
function Ce(e) {
  const t = [];
  return p(e.color) && t.push("颜色"), t.join(" * ");
}
function Ee(e) {
  return "";
}
const Ne = { __name: "steel-plate", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, showWidth: { type: Boolean, default: true }, showLength: { type: Boolean, default: true }, showThickness: { type: Boolean, default: true }, showClassification: { type: Boolean, default: false }, sortable: { type: [String, Boolean], default: false }, modelNameLabel: { type: String, default: "材质" } }, setup(e) {
  const t = e, { loaded: c, baseUnit: u } = G(t.basicClass), y = d(() => v(t.columns) || t.columns.visible("specification")), T = d(() => v(t.columns) || t.columns.visible("otherMerge")), x = d(() => t.showThickness && c.value && (v(t.columns) || t.columns.visible("thickness"))), h = d(() => t.showWidth && c.value && (v(t.columns) || t.columns.visible("width"))), f = d(() => t.showLength && c.value && (v(t.columns) || t.columns.visible("length")));
  return (V, N) => {
    const k = _, O = j;
    return t.specMerge ? (l(), m(w, { key: 0 }, [y.value ? (l(), n(O, { key: "specificationMerge", fixed: e.fixed, align: "center", label: "规格", prop: "specificationMerge", "show-overflow-tooltip": "", width: "200px" }, { default: i(({ row: g }) => [S(k, { content: a(A)(g), placement: "left" }, { default: i(() => [M("span", null, b(a(R)(g)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 1 }, [y.value ? (l(), n(O, { key: "specification_2", fixed: e.fixed, label: e.specOnly ? e.modelNameLabel : "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: i(({ row: g }) => [S(k, { content: g.specificationLabels, disabled: !g.specificationLabels, placement: "left" }, { default: i(() => [B(b(g.specification), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "label"])) : s("", true), e.specOnly ? (l(), m(w, { key: 1 }, [T.value ? (l(), n(O, { key: "otherMerge", fixed: e.fixed, align: "center", label: "规格", prop: "otherMerge", "show-overflow-tooltip": "", width: "200px" }, { default: i(({ row: g }) => [S(k, { content: a($)(g), placement: "left" }, { default: i(() => [M("span", null, b(a(z)(g)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 2 }, [x.value ? (l(), n(O, { key: "thickness", fixed: e.fixed, label: `厚 (${a(u).thickness.unit})`, sortable: e.sortable, align: "center", prop: "thickness", "show-overflow-tooltip": "", width: "100px" }, null, 8, ["fixed", "label", "sortable"])) : s("", true), h.value ? (l(), n(O, { key: "width", fixed: e.fixed, label: `宽 (${a(u).width.unit})`, align: "center", prop: "width", "show-overflow-tooltip": "", width: "120px" }, null, 8, ["fixed", "label"])) : s("", true), f.value ? (l(), n(O, { key: "length", fixed: e.fixed, label: `长 (${a(u).length.unit})`, align: "center", prop: "length", "show-overflow-tooltip": "", width: "120px" }, null, 8, ["fixed", "label"])) : s("", true)], 64))], 64));
  };
} }, Ve = { __name: "section-steel", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, showLength: { type: Boolean, default: true }, sortable: { type: [String, Boolean], default: false }, modelNameLabel: { type: String, default: "材质" } }, setup(e) {
  const t = e, { loaded: c, baseUnit: u } = G(t.basicClass), y = d(() => v(t.columns) || t.columns.visible("specification")), T = d(() => v(t.columns) || t.columns.visible("otherMerge")), x = d(() => t.showLength && c.value && (v(t.columns) || t.columns.visible("length")));
  return (h, f) => {
    const V = _, N = j;
    return t.specMerge ? (l(), m(w, { key: 0 }, [y.value ? (l(), n(N, { key: "specificationMerge", fixed: e.fixed, align: "center", label: "规格", prop: "specificationMerge", "show-overflow-tooltip": "", width: "250px" }, { default: i(({ row: k }) => [S(V, { content: a(A)(k), placement: "left" }, { default: i(() => [M("span", null, b(a(R)(k)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 1 }, [y.value ? (l(), n(N, { key: "specification_2", fixed: e.fixed, label: e.specOnly ? e.modelNameLabel : "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", width: "250px" }, { default: i(({ row: k }) => [S(V, { content: k.specificationLabels, disabled: !k.specificationLabels, placement: "left" }, { default: i(() => [B(b(k.specification), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "label"])) : s("", true), e.specOnly ? (l(), m(w, { key: 1 }, [T.value ? (l(), n(N, { key: "otherMerge", fixed: e.fixed, align: "center", label: "规格", prop: "otherMerge", "show-overflow-tooltip": "", width: "200px" }, { default: i(({ row: k }) => [S(V, { content: a($)(k), placement: "left" }, { default: i(() => [M("span", null, b(a(z)(k)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 2 }, [x.value ? (l(), n(N, { key: "length", fixed: e.fixed, label: `长 (${a(u).length.unit})`, align: "center", prop: "length", "show-overflow-tooltip": "", width: "120px" }, null, 8, ["fixed", "label"])) : s("", true)], 64))], 64));
  };
} }, Be = { __name: "steel-coil", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, showWidth: { type: Boolean, default: true }, showThickness: { type: Boolean, default: true }, sortable: { type: [String, Boolean], default: false }, modelNameLabel: { type: String, default: "材质" } }, setup(e) {
  const t = e, { loaded: c, baseUnit: u } = G(t.basicClass), y = d(() => v(t.columns) || t.columns.visible("specification")), T = d(() => v(t.columns) || t.columns.visible("otherMerge")), x = d(() => t.showThickness && c.value && (v(t.columns) || t.columns.visible("thickness"))), h = d(() => t.showWidth && c.value && (v(t.columns) || t.columns.visible("width"))), f = d(() => v(t.columns) || t.columns.visible("color"));
  return (V, N) => {
    const k = _, O = j;
    return t.specMerge ? (l(), m(w, { key: 0 }, [y.value ? (l(), n(O, { key: "specificationMerge", fixed: e.fixed, align: "center", label: "规格", prop: "specificationMerge", "show-overflow-tooltip": "", width: "260px" }, { default: i(({ row: g }) => [S(k, { content: a(A)(g), placement: "left" }, { default: i(() => [M("span", null, b(a(R)(g)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 1 }, [y.value ? (l(), n(O, { key: "specification_2", fixed: e.fixed, label: e.specOnly ? e.modelNameLabel : "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", width: "140px" }, { default: i(({ row: g }) => [S(k, { content: g.specificationLabels, disabled: !g.specificationLabels, placement: "left" }, { default: i(() => [B(b(g.specification), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "label"])) : s("", true), e.specOnly ? (l(), m(w, { key: 1 }, [T.value ? (l(), n(O, { key: "otherMerge", fixed: e.fixed, align: "center", label: "规格", prop: "otherMerge", "show-overflow-tooltip": "", width: "200px" }, { default: i(({ row: g }) => [S(k, { content: a($)(g), placement: "left" }, { default: i(() => [M("span", null, b(a(z)(g)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 2 }, [x.value ? (l(), n(O, { key: "thickness", fixed: e.fixed, label: `厚 (${a(u).thickness.unit})`, sortable: e.sortable, align: "center", prop: "thickness", "show-overflow-tooltip": "", width: "100px" }, null, 8, ["fixed", "label", "sortable"])) : s("", true), h.value ? (l(), n(O, { key: "width", fixed: e.fixed, label: `宽 (${a(u).width.unit})`, align: "center", prop: "width", "show-overflow-tooltip": "", width: "120px" }, null, 8, ["fixed", "label"])) : s("", true), f.value ? (l(), n(O, { key: 2, fixed: e.fixed, label: "颜色", align: "center", prop: "color", "show-overflow-tooltip": "", width: "120px" }, null, 8, ["fixed"])) : s("", true)], 64))], 64));
  };
} }, _e = { __name: "aux-mat", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false }, modelNameLabel: { type: String, default: "材质" } }, setup(e) {
  const t = e, c = d(() => v(t.columns) || t.columns.visible("specification")), u = d(() => v(t.columns) || t.columns.visible("color"));
  return (y, T) => {
    const x = _, h = j;
    return t.specMerge ? (l(), m(w, { key: 0 }, [c.value ? (l(), n(h, { key: "specificationMerge", fixed: e.fixed, align: "center", label: "规格", "min-width": "180px", prop: "specificationMerge", "show-overflow-tooltip": "" }, { default: i(({ row: f }) => [S(x, { content: a(A)(f), placement: "left" }, { default: i(() => [M("span", null, b(a(R)(f)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 1 }, [c.value ? (l(), n(h, { key: "specification_2", fixed: e.fixed, label: e.modelNameLabel, align: "center", "min-width": "180px", prop: "specification", "show-overflow-tooltip": "" }, { default: i(({ row: f }) => [S(x, { content: f.specificationLabels, disabled: !f.specificationLabels, placement: "left" }, { default: i(() => [B(b(f.specification), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "label"])) : s("", true), u.value ? (l(), n(h, { key: 1, fixed: e.fixed, label: "颜色", align: "center", prop: "color", "show-overflow-tooltip": "", width: "120px" }, null, 8, ["fixed"])) : s("", true)], 64));
  };
} }, je = { __name: "gas", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false }, modelNameLabel: { type: String, default: "材质" } }, setup(e) {
  const t = e, c = d(() => v(t.columns) || t.columns.visible("specification"));
  return (u, y) => {
    const T = _, x = j;
    return t.specMerge ? (l(), m(w, { key: 0 }, [c.value ? (l(), n(x, { key: "specificationMerge", fixed: e.fixed, align: "center", label: "规格", "min-width": "180px", prop: "specificationMerge", "show-overflow-tooltip": "" }, { default: i(({ row: h }) => [S(T, { content: a(A)(h), placement: "left" }, { default: i(() => [M("span", null, b(a(R)(h)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : (l(), m(w, { key: 1 }, [c.value ? (l(), n(x, { key: "specification_2", fixed: e.fixed, label: e.modelNameLabel, align: "center", "min-width": "180px", prop: "specification", "show-overflow-tooltip": "" }, { default: i(({ row: h }) => [S(T, { content: h.specificationLabels, disabled: !h.specificationLabels, placement: "left" }, { default: i(() => [B(b(h.specification), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "label"])) : s("", true)], 64));
  };
} }, Ae = { __name: "raw-mat", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false }, modelNameLabel: { type: String, default: "材质" } }, setup(e) {
  const t = e, c = d(() => v(t.columns) || t.columns.visible("specification")), u = d(() => v(t.columns) || t.columns.visible("otherMerge"));
  return (y, T) => {
    const x = _, h = j;
    return l(), m(w, null, [c.value && e.specMerge ? (l(), n(h, { key: "specificationMerge", fixed: e.fixed, align: "center", label: "规格", "min-width": "200", prop: "specificationMerge", "show-overflow-tooltip": "" }, { default: i(({ row: f }) => [S(x, { content: a(A)(f), placement: "left" }, { default: i(() => [M("span", null, b(a(R)(f)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : s("", true), e.specOnly ? (l(), m(w, { key: 1 }, [c.value ? (l(), n(h, { key: "specification_2", fixed: e.fixed, label: e.specOnly ? e.modelNameLabel : "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", width: "250px" }, { default: i(({ row: f }) => [[a(r).STEEL_PLATE.V, a(r).SECTION_STEEL.V, a(r).STEEL_COIL.V].includes(f.basicClass) ? (l(), n(x, { key: 0, content: f.specificationLabels, disabled: !f.specificationLabels, placement: "left" }, { default: i(() => [B(b(f.specification), 1)]), _: 2 }, 1032, ["content", "disabled"])) : (l(), n(x, { key: 1, content: a($)(f), placement: "left" }, { default: i(() => [M("span", null, b(a(z)(f) || "-"), 1)]), _: 2 }, 1032, ["content"]))]), _: 1 }, 8, ["fixed", "label"])) : s("", true), u.value ? (l(), n(h, { key: "otherMerge", fixed: e.fixed, align: "center", label: "规格", prop: "otherMerge", "show-overflow-tooltip": "", width: "200px" }, { default: i(({ row: f }) => [[a(r).STEEL_PLATE.V, a(r).SECTION_STEEL.V, a(r).STEEL_COIL.V].includes(f.basicClass) ? (l(), n(x, { key: 0, content: a($)(f), placement: "left" }, { default: i(() => [M("span", null, b(a(z)(f) || "-"), 1)]), _: 2 }, 1032, ["content"])) : (l(), n(x, { key: 1, content: f.specificationLabels, disabled: !f.specificationLabels, placement: "left" }, { default: i(() => [B(b(f.specification), 1)]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }, 8, ["fixed"])) : s("", true)], 64)) : s("", true)], 64);
  };
} };
const Re = { key: 0, class: "table-cell-triangle-frozen" }, Ie = ["onClick"], Pe = { key: 1 }, ze = { __name: "index", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, showIndex: { type: Boolean, default: true }, showClassification: { type: Boolean, default: false }, showSerialNumber: { type: Boolean, default: true }, showProject: { type: Boolean, default: false }, showRejectStatus: { type: Boolean, default: false }, showPartyA: { type: Boolean, default: true }, showPartyATransfer: { type: Boolean, default: false }, partyAPosition: { type: String, default: "index" }, showIsWhole: { type: Boolean, default: false }, showOutboundMode: { type: Boolean, default: false }, showOddmentByHalfOut: { type: Boolean, default: false }, showFrozenTip: { type: Boolean, default: false }, frozenViewable: { type: Boolean, default: false }, rejectDetailViewable: { type: Boolean, default: false }, fixed: { type: String }, sortable: { type: Boolean, default: false }, classifyNameAlias: { type: String, default: "物料种类" }, showTip: { type: Boolean, default: false }, modelNameLabel: { type: String, default: "材质" }, isSerialNumber: { type: Boolean, default: true } }, emits: ["refresh", "unfreeze-success"], setup(e, { emit: t }) {
  const c = t, u = e, y = F({}), T = F(false), x = F(false), h = F(0), f = d(() => !u.basicClass || u.basicClass > de ? 160 : 120), V = d(() => v(u.columns) || u.columns.visible("classifyName")), N = d(() => u.showSerialNumber && (v(u.columns) || u.columns.visible("serialNumber"))), k = d(() => u.frozenViewable && pe(he.frozenDetail)), O = d(() => u.sortable === true ? "custom" : false), { maxHeight: g } = me({ mainBox: ".wms-material-freeze-record-view", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, d(() => T.value || x.value));
  function te(L) {
    const E = L.sourceRow ? L.sourceRow : L;
    h.value = 0, y.value = JSON.parse(JSON.stringify(E)), T.value = true;
  }
  function le(L) {
    if (!u.rejectDetailViewable) return;
    const E = L.sourceRow ? L.sourceRow : L;
    y.value = E, x.value = true;
  }
  function ae(L, E, C) {
    ++h.value, c("unfreeze-success", L, E, C);
  }
  function ne(L) {
    h.value > 0 && c("refresh"), L();
  }
  const oe = d(() => {
    switch (u.basicClass) {
      case r.STEEL_PLATE.V:
        return Ne;
      case r.SECTION_STEEL.V:
        return Ve;
      case r.STEEL_COIL.V:
        return Be;
      case r.MATERIAL.V:
        return _e;
      case r.GAS.V:
        return je;
      default:
        return Ae;
    }
  });
  return (L, E) => {
    var Q;
    const C = K("table-cell-tag"), I = j, se = _, J = K("common-dialog");
    return l(), m(w, null, [e.showIndex ? (l(), n(I, { key: 0, fixed: e.fixed, align: "center", label: "序号", type: "index", width: "55" }, { default: i(({ row: o, $index: P }) => [e.showPartyA && e.partyAPosition === "index" ? (l(), n(C, { key: 0, show: !!o.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : s("", true), M("span", null, b(P + 1), 1)]), _: 1 }, 8, ["fixed"])) : s("", true), X(L.$slots, "afterIndex", {}, void 0, true), e.showProject ? (l(), n(I, { key: 1, fixed: e.fixed, prop: "project", align: "left", label: "项目", "min-width": "120px", "show-overflow-tooltip": "" }, { default: i(({ row: o }) => [e.showPartyA && e.partyAPosition === "project" ? (l(), n(C, { key: 0, offset: 15, show: !!o.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : s("", true), M("span", null, b(o.project), 1)]), _: 1 }, 8, ["fixed"])) : s("", true), N.value ? (l(), n(I, { key: 2, fixed: e.fixed, prop: e.isSerialNumber ? "serialNumber" : "materialSn", sortable: O.value, align: "center", label: "物料编号", "show-overflow-tooltip": "", width: "110px" }, { default: i(({ row: o }) => {
      var P, Y, Z, q;
      return [e.showPartyATransfer && o.partyATransferType ? (l(), n(C, { key: 0, color: (P = a(ee).V[o.partyATransferType]) == null ? void 0 : P.COLOR, name: a(ee).VL[o.partyATransferType], offset: 15 }, null, 8, ["color", "name"])) : s("", true), e.showIsWhole && o.materialIsWhole === a(D).ODDMENT.V ? (l(), n(C, { key: 1, color: (Y = a(D).V[o.materialIsWhole]) == null ? void 0 : Y.COLOR, name: a(D).VL[o.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : s("", true), e.showOddmentByHalfOut ? (l(), n(C, { key: 2, color: o.outboundRelationType === a(U).CUT.V || o.outboundRelationType === a(U).CUT_TRANSFER.V ? "#214283" : "#e6a23c", name: o.outboundRelationType === a(U).CUT.V || o.outboundRelationType === a(U).CUT_TRANSFER.V ? "切割半出" : "半出余料", show: !!o.boolOddmentByHalfOut }, null, 8, ["color", "name", "show"])) : s("", true), e.showOutboundMode && o.materialOutboundMode === a(W).HALF.V ? (l(), n(C, { key: 3, color: (Z = a(W).V[o.materialOutboundMode]) == null ? void 0 : Z.COLOR, name: a(W).VL[o.materialOutboundMode], offset: 15 }, null, 8, ["color", "name"])) : s("", true), e.showOutboundMode && o.basicClass & a(r).STEEL_COIL.V && o.length ? (l(), n(C, { key: 4, name: o.boolBasicClassChange ? "出至钢板库" : "条板出库", offset: 15, color: "#e6a23c" }, null, 8, ["name"])) : s("", true), e.showRejectStatus ? (l(), m(w, { key: 5 }, [a(p)(o.rejectStatus) && o.rejectStatus !== a(H).NONE.V ? (l(), n(C, { key: 0, class: ie({ pointer: e.rejectDetailViewable }), color: (q = a(H).V[o.rejectStatus]) == null ? void 0 : q.COLOR, name: a(H).VL[o.rejectStatus], onClick: ($e) => le(o) }, null, 8, ["class", "color", "name", "onClick"])) : s("", true)], 64)) : s("", true), e.showTip && o.basicClass === a(r).STEEL_PLATE.V ? (l(), n(C, { key: 6, color: "#f23c3c", offset: 15, show: o.boolReturns, name: "退余料" }, null, 8, ["show"])) : s("", true), M("span", null, b(o.serialNumber), 1)];
    }), _: 1 }, 8, ["fixed", "prop", "sortable"])) : s("", true), X(L.$slots, "afterMaterialSn", {}, void 0, true), e.showClassification ? (l(), n(I, { key: 3, fixed: e.fixed, align: "center", label: "分类", prop: "classification", "show-overflow-tooltip": "", width: "100px" }, null, 8, ["fixed"])) : s("", true), V.value ? (l(), n(I, { key: 4, fixed: e.fixed, label: e.classifyNameAlias, width: f.value, align: "center", prop: "classifyName", "show-overflow-tooltip": "" }, { default: i(({ row: o }) => [e.showFrozenTip && o.boolHasFrozen ? (l(), m("span", Re)) : s("", true), S(se, { content: o.classifyParentFullName, disabled: !o.classifyParentFullName, "show-after": 500, placement: "top" }, { default: i(() => [M("span", null, [k.value && o.boolHasFrozen ? (l(), m("span", { key: 0, class: "freeze-text", onClick: (P) => te(o) }, b(o.classifyName), 9, Ie)) : (l(), m("span", Pe, b(o.classifyName), 1))])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "label", "width"])) : s("", true), (l(), n(ue(oe.value), ce({ "basic-class": e.basicClass, columns: e.columns, "model-name-label": u.modelNameLabel, showClassification: e.showClassification, sortable: O.value, "spec-merge": e.specMerge, "spec-only": e.specOnly }, L.$attrs), null, 16, ["basic-class", "columns", "model-name-label", "showClassification", "sortable", "spec-merge", "spec-only"])), S(J, { modelValue: T.value, "onUpdate:modelValue": E[0] || (E[0] = (o) => T.value = o), "before-close": ne, title: `冻结记录：${y.value.classifyName} ${((Q = y.value) == null ? void 0 : Q.specification) || ""}`, "custom-class": "wms-material-freeze-record-view", "show-close": "", top: "10vh", width: "1300px" }, { default: i(() => [S(be, { material: y.value, "max-height": a(g), onUnfreezeSuccess: ae }, null, 8, ["material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"]), S(J, { modelValue: x.value, "onUpdate:modelValue": E[1] || (E[1] = (o) => x.value = o), title: `退货记录：${y.value.classifyName} ${y.value.specification}`, "custom-class": "wms-material-reject-material-record-view", "show-close": "", top: "10vh", width: "80%" }, { default: i(() => [S(ye, { "basic-class": y.value.basicClass, list: y.value.rejectList, material: y.value, "max-height": a(g), "has-border": "" }, null, 8, ["basic-class", "list", "material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"])], 64);
  };
} }, De = re(ze, [["__scopeId", "data-v-8bfcd95d"]]);
export {
  De as M
};
