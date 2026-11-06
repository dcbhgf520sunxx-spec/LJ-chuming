import { ref as u } from "vue";
import { watchEffect as j } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as q } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as v } from "vue";
import { renderList as L } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as m } from "vue";
import { withDirectives as A } from "vue";
import { unref as l } from "vue";
import { createVNode as a } from "vue";
import { createCommentVNode as V } from "vue";
import { isRef as F } from "vue";
import { ElTag as z } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { vLoading as K } from "element-plus";
import { b as Q } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { _ as $, u as J, o as O, K as W, bw as E, bi as X, bs as Y, D as Z, ba as ee } from "../../../../../../shared/runtime.js";
const te = { class: "tag-box" }, ae = { __name: "detail", props: { visible: { type: Boolean, default: false }, packageList: { type: Array, required: true } }, emits: ["update:visible"], setup(h, { emit: C }) {
  const k = u(), D = C, f = h, { visible: w, handleClose: B } = J({ emit: D, props: f, field: "visible", showHook: N }), { maxHeight: I } = O({ extraBox: [".el-drawer__header", ".tag-box"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => k.value.loaded), g = u(false), x = u([]), T = u([]), _ = u();
  j(() => {
    T.value = x.value.filter((n) => n.packageId === _.value);
  });
  function N() {
    M();
  }
  async function M() {
    var n;
    try {
      g.value = true;
      const { content: s } = await Q({ packageIdList: (n = f.packageList) == null ? void 0 : n.map((c) => c.id) });
      x.value = s, _.value = f.packageList[0].id;
    } catch (s) {
      console.log("详情", s);
    } finally {
      g.value = false;
    }
  }
  function R(n) {
    return ee(n, { props: ["quantity", "mete"] });
  }
  return (n, s) => {
    const c = z, t = G, H = y("table-cell-tag"), S = y("common-table"), P = y("common-drawer"), U = K;
    return o(), i(P, { ref_key: "drawerRef", ref: k, title: "打包清单", modelValue: l(w), "onUpdate:modelValue": s[0] || (s[0] = (e) => F(w) ? w.value = e : null), direction: "rtl", "before-close": l(B), size: "80%" }, { content: r(() => [q("div", te, [(o(true), b(v, null, L(h.packageList, (e) => (o(), i(c, { effect: e.id === _.value ? "dark" : "plain", key: e.id, onClick: (p) => _.value = e.id }, { default: r(() => [d(" 包单号：" + m(e.serialNumber), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))]), A((o(), i(S, { data: T.value || [], "max-height": l(I), "show-summary": "", "summary-method": R, "empty-text": "暂无数据", style: { width: "100%" } }, { default: r(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), a(t, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), a(t, { "show-overflow-tooltip": true, prop: "area.name", label: "区域" }), a(t, { "show-overflow-tooltip": true, prop: "productType", align: "center", label: "产品类型", width: "90" }, { default: r((e) => [f.projectType === l(W).BRIDGE.V ? (o(), i(c, { key: 0, type: l(E).V[e.row.productType].T, effect: "plain", style: { "margin-right": "5px" } }, { default: r(() => [d(m(l(E).VL[e.row.productType]), 1)]), _: 2 }, 1032, ["type"])) : (o(true), b(v, { key: 1 }, L(l(X).ENUM, (p) => (o(), b(v, { key: p }, [e.row.productType & p.V ? (o(), i(c, { key: 0, type: p.T, effect: "plain", style: { "margin-right": "5px" } }, { default: r(() => [d(m(p.L), 1)]), _: 2 }, 1032, ["type"])) : V("", true)], 64))), 128))]), _: 1 }), a(t, { "show-overflow-tooltip": true, prop: "name", label: "名称/类型" }, { default: r((e) => [e.row.warehouseType === 1 ? (o(), i(H, { key: 0, name: "回厂返修", color: "#e64242", offset: 30 })) : V("", true), d(" " + m(e.row.name), 1)]), _: 1 }), a(t, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), a(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), a(t, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", align: "center" }, { default: r((e) => [d(m(l(Y)(e.row.length, l(Z).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), a(t, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }), a(t, { "show-overflow-tooltip": true, align: "center", prop: "packageQuantity", label: "数量" }), a(t, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位" }), a(t, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量" })]), _: 1 }, 8, ["data", "max-height"])), [[U, g.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = $(ae, [["__scopeId", "data-v-c8df45d7"]]);
export {
  ne as default
};
