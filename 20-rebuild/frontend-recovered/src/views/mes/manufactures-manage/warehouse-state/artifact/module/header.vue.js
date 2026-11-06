import { ref as M } from "vue";
import { watch as G } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as I } from "vue";
import { vShow as z } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as u } from "vue";
import { createBlock as g } from "vue";
import { Loading as B } from "@element-plus/icons-vue";
import { ElIcon as D } from "element-plus";
import { ElTag as K } from "element-plus";
import { a as R } from "../../../../../../modules/common-85b8c78d.js";
import { B as x, a3 as j, m as L, G as P, ng as U, C as $, bs as k, D as b, E as F } from "../../../../../../shared/runtime.js";
import { _ as N } from "../../../../../../modules/index-b238c21c.js";
import { _ as H } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as J } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const X = { class: "head-container" }, Y = { key: 0 }, Z = { key: 0 }, ee = { key: 0 }, te = { key: 0 }, ae = { key: 0 }, me = { __name: "header", setup(ne) {
  const C = { name: "", serialNumber: "", specification: "", material: "", factoryId: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false } }, { crud: r, query: l, CRUD: v } = x(C), T = j.ARTIFACT.V, { globalProjectId: w } = L(["globalProjectId"]), i = M({ quantity: 0, taskQuantity: 0, inboundQuantity: 0, outboundQuantity: 0, stockQuantity: 0, mete: 0, taskMete: 0, inboundMete: 0, outboundMete: 0, stockMete: 0 }), d = M(false);
  G([() => r.query.monomerId, () => r.query.factoryId], () => {
    W();
  }, { immediate: true }), v.HOOK.handleRefresh = (c, a) => {
    a.data.content = a.data.content.map((t) => (t.weight = t.netWeight || 0, t.totalWeight = t.weight * t.quantity, t.stockQuantity = t.inboundQuantity - t.outboundQuantity || 0, t.inboundWeight = t.inboundQuantity * t.weight, t.outboundWeight = t.outboundQuantity * t.weight, t.stockWeight = t.stockQuantity * t.weight, t));
  };
  async function W() {
    if (!(!P(r.permission.get) || !l.monomerId)) {
      d.value = true;
      try {
        const c = { monomerId: l.monomerId, factoryId: l.factoryId }, { quantity: a = 0, taskQuantity: t = 0, inboundQuantity: m = 0, outboundQuantity: p = 0, stockQuantity: f = 0, mete: Q = 0, taskMete: h = 0, outboundMete: A = 0, inboundMete: E = 0, stockMete: O = 0 } = await R(c);
        i.value = { quantity: a, taskQuantity: t, inboundQuantity: m, outboundQuantity: p, stockQuantity: f, mete: Q, taskMete: h, inboundMete: E, outboundMete: A, stockMete: O };
      } catch (c) {
        console.log("获取汇总数据", c);
      } finally {
        d.value = false;
      }
    }
  }
  function q({ monomerId: c, areaId: a }) {
    l.monomerId = c, l.areaId = a, r.toQuery();
  }
  return (c, a) => {
    const t = S("print-table"), m = B, p = D, f = K, Q = V("permission");
    return o(), y("div", X, [I(_("div", null, [n(e(H), { "project-id": e(w), areaType: e(U).STRUCTURE.V, productType: e(T), needConvert: "", onChange: q }, null, 8, ["project-id", "areaType", "productType"]), n(e(J), { modelValue: e(l).factoryId, "onUpdate:modelValue": a[0] || (a[0] = (h) => e(l).factoryId = h), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(N), { productType: e(T), toQuery: e(r).toQuery, query: e(l) }, null, 8, ["productType", "toQuery", "query"]), n(e($))], 512), [[z, e(r).searchToggle]]), n(e(F), null, { optLeft: s(() => [I(n(t, { "api-key": "mesWarehouseStateStructure", params: { ...e(l) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[Q, e(r).permission.print]])]), viewLeft: s(() => [I((o(), y("span", null, [n(f, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [a[1] || (a[1] = _("span", null, "清单量：", -1)), d.value ? (o(), g(p, { key: 1 }, { default: s(() => [n(m)]), _: 1 })) : (o(), y("span", Y, u(i.value.quantity) + " 件 | " + u(e(k)(i.value.mete, e(b).COM_WT__KG)) + " kg", 1))]), _: 1, __: [1] }), n(f, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [a[2] || (a[2] = _("span", null, "任务量：", -1)), d.value ? (o(), g(p, { key: 1 }, { default: s(() => [n(m)]), _: 1 })) : (o(), y("span", Z, u(i.value.taskQuantity) + " 件 | " + u(e(k)(i.value.taskMete, e(b).COM_WT__KG)) + " kg", 1))]), _: 1, __: [2] }), n(f, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [a[3] || (a[3] = _("span", null, "入库量：", -1)), d.value ? (o(), g(p, { key: 1 }, { default: s(() => [n(m)]), _: 1 })) : (o(), y("span", ee, u(i.value.inboundQuantity) + " 件 | " + u(e(k)(i.value.inboundMete, e(b).COM_WT__KG)) + " kg ", 1))]), _: 1, __: [3] }), n(f, { effect: "plain", size: "large", class: "filter-item" }, { default: s(() => [a[4] || (a[4] = _("span", null, "出库量：", -1)), d.value ? (o(), g(p, { key: 1 }, { default: s(() => [n(m)]), _: 1 })) : (o(), y("span", te, u(i.value.outboundQuantity) + " 件 | " + u(e(k)(i.value.outboundMete, e(b).COM_WT__KG)) + " kg ", 1))]), _: 1, __: [4] }), n(f, { effect: "plain", size: "large", class: "filter-item", type: "success" }, { default: s(() => [a[5] || (a[5] = _("span", null, "库存量：", -1)), d.value ? (o(), g(p, { key: 1 }, { default: s(() => [n(m)]), _: 1 })) : (o(), y("span", ae, u(i.value.stockQuantity) + " 件 | " + u(e(k)(i.value.stockMete, e(b).COM_WT__KG)) + " kg", 1))]), _: 1, __: [5] })])), [[Q, e(r).permission.get]])]), _: 1 })]);
  };
} };
export {
  me as default
};
