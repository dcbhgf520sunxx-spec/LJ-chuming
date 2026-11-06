import { ref as g } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as T } from "vue";
import { vShow as B } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as o } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as p } from "vue";
import { createBlock as I } from "vue";
import { Loading as U } from "@element-plus/icons-vue";
import { ElIcon as M } from "element-plus";
import { ElTag as N } from "element-plus";
import { a as j } from "../../../../../../modules/common-85b8c78d.js";
import { o3 as F, B as W, a3 as G, m as H, ng as K, C as L, bs as h, D as v, E as P } from "../../../../../../shared/runtime.js";
import { u as Z } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { C as z } from "../../../../../../modules/index-d6a37d29.js";
import { S as J } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as X } from "../../../../../../modules/index-b238c21c.js";
import { _ as Y } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as ee } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const te = { class: "head-container" }, ae = { key: 0 }, oe = { key: 0 }, ne = { key: 0 }, be = { __name: "header", emits: "load", setup(se, { expose: Q, emit: k }) {
  const q = { name: "", serialNumber: "", specification: "", material: "", type: F.INBOUND.V, status: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false } }, { crud: u, query: n, CRUD: x } = W(q), C = G.ARTIFACT.V, { globalProjectId: R } = H(["globalProjectId"]), A = k, y = g(1), i = g(false), c = g({ mete: void 0, inboundMete: void 0, inboundRate: void 0 }), { colors: E, boxZoomOut: O, getColor: S } = Z({ colorCardTitles: ["未入库", "部分入库", "全部入库"], emit: A, crud: u, fetchSummaryInfo: $ });
  async function $() {
    if (n.monomerId) {
      i.value = true;
      try {
        const s = { monomerId: n.monomerId, factoryId: n.factoryId }, { mete: a = 0, inboundMete: t = 0 } = await j(s);
        c.value = { mete: a, inboundMete: t, inboundRate: a ? (t / a * 100).toFixed(1) + "%" : 0 };
      } catch (s) {
        console.log("获取汇总数据", s);
      } finally {
        i.value = false;
      }
    }
  }
  x.HOOK.handleRefresh = (s, a) => {
    a.data.content = a.data.content.map((t) => (t.compareQuantity = s.query.factoryId ? t.taskQuantity : t.quantity, t.quantityInfo = `-------------------------

清单数量：${t.quantity}

`, s.query.factoryId && (t.quantityInfo += `任务数量：${t.taskQuantity}

`), t.quantityInfo += `入库数量：${t.inboundQuantity}

        出库数量：${t.outboundQuantity}

        库存数量：${t.inboundQuantity - t.outboundQuantity}
`, t.boxColor = S(t, { quantity: "inboundQuantity", compare: "compareQuantity" }), t));
  };
  function w({ monomerId: s, areaId: a }) {
    n.monomerId = s, n.areaId = a, u.toQuery();
  }
  return Q({ boxScale: y }), (s, a) => {
    const t = U, _ = M, b = N, D = V("permission");
    return r(), m("div", te, [T(f("div", null, [o(e(Y), { "project-id": e(R), areaType: e(K).STRUCTURE.V, productType: e(C), needConvert: "", onChange: w }, null, 8, ["project-id", "areaType", "productType"]), o(e(ee), { modelValue: e(n).factoryId, "onUpdate:modelValue": a[0] || (a[0] = (d) => e(n).factoryId = d), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(u).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(X), { productType: e(C), toQuery: e(u).toQuery, query: e(n) }, null, 8, ["productType", "toQuery", "query"]), o(e(L))], 512), [[B, e(u).searchToggle]]), o(e(P), { "show-grid": false, "show-refresh": false }, { optRight: l(() => [o(e(z), { class: "filter-item", value: e(n).status, "onUpdate:value": a[1] || (a[1] = (d) => e(n).status = d), colors: e(E), "color-border": "", "select-able": "", onChange: e(u).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: l(() => [T((r(), m("span", null, [o(b, { effect: "plain", class: "filter-item" }, { default: l(() => [f("span", null, p(e(n).factoryId ? "任务量" : "清单量") + "：", 1), i.value ? (r(), I(_, { key: 1 }, { default: l(() => [o(t)]), _: 1 })) : (r(), m("span", ae, p(e(h)(c.value.mete, e(v).COM_WT__KG)) + " kg", 1))]), _: 1 }), o(b, { effect: "plain", class: "filter-item" }, { default: l(() => [a[3] || (a[3] = f("span", null, "入库量：", -1)), i.value ? (r(), I(_, { key: 1 }, { default: l(() => [o(t)]), _: 1 })) : (r(), m("span", oe, p(e(h)(c.value.inboundMete, e(v).COM_WT__KG)) + " kg", 1))]), _: 1, __: [3] }), o(b, { effect: "plain", class: "filter-item", type: "success" }, { default: l(() => [a[4] || (a[4] = f("span", null, "完成率：", -1)), i.value ? (r(), I(_, { key: 1 }, { default: l(() => [o(t)]), _: 1 })) : (r(), m("span", ne, p(c.value.inboundRate), 1))]), _: 1, __: [4] })])), [[D, e(u).permission.get]]), o(e(J), { class: "filter-item", value: y.value, "onUpdate:value": a[2] || (a[2] = (d) => y.value = d), intervals: 400, onZoomOut: e(O) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  be as default
};
