import { ref as L } from "vue";
import { watch as O } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as M } from "vue";
import { vShow as T } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as n } from "vue";
import { withKeys as v } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as i } from "vue";
import { createBlock as k } from "vue";
import { ElInput as x } from "element-plus";
import { Loading as B } from "@element-plus/icons-vue";
import { ElIcon as D } from "element-plus";
import { ElTag as K } from "element-plus";
import { c as A } from "../../../../../../modules/common-85b8c78d.js";
import { B as j, a3 as P, m as $, G, C as H, c as b, D as E, E as W } from "../../../../../../shared/runtime.js";
import { _ as F } from "../../../../../../modules/index-b238c21c.js";
import { _ as J } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as X } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const Y = { class: "head-container" }, Z = { key: 0 }, ee = { key: 0 }, te = { key: 0 }, ae = { key: 0 }, ne = { key: 0 }, pe = { __name: "header", setup(oe) {
  const S = { name: "", serialNumber: "", specification: "", material: "", factoryId: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false } }, { crud: u, query: o, CRUD: C } = j(S), I = P.ENCLOSURE.V, { globalProjectId: w } = $(["globalProjectId"]), r = L({ quantity: 0, taskQuantity: 0, inboundQuantity: 0, outboundQuantity: 0, stockQuantity: 0, mete: 0, taskMete: 0, inboundMete: 0, outboundMete: 0, stockMete: 0 }), m = L(false);
  O([() => u.query.monomerId, () => u.query.factoryId], () => {
    V();
  }, { immediate: true }), C.HOOK.handleRefresh = (d, t) => {
    t.data.content = t.data.content.map((a) => (a.length = a.length || 0, a.totalLength = a.length * a.quantity, a.stockQuantity = a.inboundQuantity - a.outboundQuantity || 0, a.inboundLength = a.inboundQuantity * a.length, a.outboundLength = a.outboundQuantity * a.length, a.stockLength = a.stockQuantity * a.length, a));
  };
  async function V() {
    if (!(!G(u.permission.get) || !o.monomerId)) {
      m.value = true;
      try {
        const d = { monomerId: o.monomerId, factoryId: o.factoryId }, { quantity: t = 0, taskQuantity: a = 0, inboundQuantity: h = 0, outboundQuantity: c = 0, stockQuantity: p = 0, mete: y = 0, taskMete: Q = 0, outboundMete: f = 0, inboundMete: q = 0, stockMete: N = 0 } = await A(d);
        r.value = { quantity: t, taskQuantity: a, inboundQuantity: h, outboundQuantity: c, stockQuantity: p, mete: y, taskMete: Q, inboundMete: q, outboundMete: f, stockMete: N };
      } catch (d) {
        console.log("获取汇总数据", d);
      } finally {
        m.value = false;
      }
    }
  }
  function U({ monomerId: d, areaId: t }) {
    o.monomerId = d, o.areaId = t, u.toQuery();
  }
  return (d, t) => {
    const a = x, h = R("print-table"), c = B, p = D, y = K, Q = z("permission");
    return l(), _("div", Y, [M(g("div", null, [n(e(J), { "project-id": e(w), productType: e(I), needConvert: "", onChange: U }, null, 8, ["project-id", "productType"]), n(e(X), { modelValue: e(o).factoryId, "onUpdate:modelValue": t[0] || (t[0] = (f) => e(o).factoryId = f), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(u).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(F), { productType: e(I), toQuery: e(u).toQuery, query: e(o) }, null, 8, ["productType", "toQuery", "query"]), n(a, { modelValue: e(o).plate, "onUpdate:modelValue": t[1] || (t[1] = (f) => e(o).plate = f), size: "default", placeholder: "输入板型搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: v(e(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(a, { modelValue: e(o).color, "onUpdate:modelValue": t[2] || (t[2] = (f) => e(o).color = f), size: "default", placeholder: "输入颜色搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: v(e(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(H))], 512), [[T, e(u).searchToggle]]), n(e(W), null, { optLeft: s(() => [M(n(h, { "api-key": "mesWarehouseStateEnclosure", params: { ...e(o) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[Q, e(u).permission.print]])]), viewLeft: s(() => [M((l(), _("span", null, [n(y, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [t[3] || (t[3] = g("span", null, "清单量：", -1)), m.value ? (l(), k(p, { key: 1 }, { default: s(() => [n(c)]), _: 1 })) : (l(), _("span", Z, i(r.value.quantity) + " 张 | " + i(e(b)(r.value.mete, "mm", "m", e(E).MES_ENCLOSURE_L__M, true)) + " m ", 1))]), _: 1, __: [3] }), n(y, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [t[4] || (t[4] = g("span", null, "任务量：", -1)), m.value ? (l(), k(p, { key: 1 }, { default: s(() => [n(c)]), _: 1 })) : (l(), _("span", ee, i(r.value.taskQuantity) + " 张 | " + i(e(b)(r.value.taskMete, "mm", "m", e(E).MES_ENCLOSURE_L__M, true)) + " m ", 1))]), _: 1, __: [4] }), n(y, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [t[5] || (t[5] = g("span", null, "入库量：", -1)), m.value ? (l(), k(p, { key: 1 }, { default: s(() => [n(c)]), _: 1 })) : (l(), _("span", te, i(r.value.inboundQuantity) + " 张 | " + i(e(b)(r.value.inboundMete, "mm", "m", e(E).MES_ENCLOSURE_L__M, true)) + " m ", 1))]), _: 1, __: [5] }), n(y, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [t[6] || (t[6] = g("span", null, "出库量：", -1)), m.value ? (l(), k(p, { key: 1 }, { default: s(() => [n(c)]), _: 1 })) : (l(), _("span", ae, i(r.value.outboundQuantity) + " 张 | " + i(e(b)(r.value.outboundMete, "mm", "m", e(E).MES_ENCLOSURE_L__M, true)) + " m ", 1))]), _: 1, __: [6] }), n(y, { effect: "plain", size: "large", class: "filter-item", type: "success" }, { default: s(() => [t[7] || (t[7] = g("span", null, "库存量：", -1)), m.value ? (l(), k(p, { key: 1 }, { default: s(() => [n(c)]), _: 1 })) : (l(), _("span", ne, i(r.value.stockQuantity) + " 张 | " + i(e(b)(r.value.stockMete, "mm", "m", e(E).MES_ENCLOSURE_L__M, true)) + " m ", 1))]), _: 1, __: [7] })])), [[Q, e(u).permission.get]])]), _: 1 })]);
  };
} };
export {
  pe as default
};
