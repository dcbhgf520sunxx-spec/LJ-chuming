import { ref as u } from "vue";
import { watch as B } from "vue";
import { resolveComponent as I } from "vue";
import { withDirectives as y } from "vue";
import { vShow as j } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as a } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as W } from "vue";
import { withKeys as q } from "vue";
import { createBlock as G } from "vue";
import { unref as o } from "vue";
import { toDisplayString as H } from "vue";
import { ElTag as U } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElPagination as M } from "element-plus";
import { vLoading as R } from "element-plus";
import { k as F, l as J } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { o as O, J as Q, uo as A, on as X, bo as b, ba as Y } from "../../../../../../shared/runtime.js";
const Z = { style: { "margin-top": "20px" } }, $ = { class: "head-container" }, oe = { __name: "train-number-list", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(m, { expose: v }) {
  const _ = u([["loadingTime", ["parse-time", "{y}-{m}-{d}"]]]), e = m, c = u([]), r = u(false), i = u({}), { maxHeight: T } = O({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: N, handleCurrentChange: x, total: S, setTotalPage: C, queryPage: g } = Q({ fetchHook: n });
  B(() => e.showType, (t) => {
    t && (i.value = {}, n());
  }, { immediate: true, deep: true });
  async function n() {
    if (c.value = [], !!e.showType) {
      r.value = true;
      try {
        const t = e.category === A.STRUCTURE.V ? F : J, { content: l = [], totalElements: h } = await t({ projectId: e.projectId, ...e.query, workshopId: e.workshopId, shipEnumType: X[e.showType].V, ...g, ...i.value });
        c.value = l, C(h), r.value = false;
      } catch (t) {
        console.log("获取详情失败", t), r.value = false;
      }
    }
  }
  function k(t) {
    return Y(t, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  return v({ refresh: n }), (t, l) => {
    const h = U, E = K, s = L, V = I("common-table"), z = M, P = R;
    return y((f(), D("div", Z, [w("div", $, [a(h, { size: "default", class: "filter-item" }, { default: d(() => l[1] || (l[1] = [W("累计车次/船次")])), _: 1, __: [1] }), a(E, { modelValue: i.value.licensePlate, "onUpdate:modelValue": l[0] || (l[0] = (p) => i.value.licensePlate = p), modelModifiers: { trim: true }, size: "default", placeholder: "输入车牌/船牌号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: q(n, ["enter"]), onChange: n }, null, 8, ["modelValue"])]), y((f(), G(V, { data: c.value, "show-empty-symbol": false, "show-summary": "", "data-format": _.value, "summary-method": k, "max-height": o(T) - 140 }, { default: d(() => [a(s, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), a(s, { "show-overflow-tooltip": "", prop: "loadingTime", key: "loadingTime", label: "发运日期", align: "center" }), a(s, { key: "serialNumber", prop: "serialNumber", label: "车次/船次号", align: "center", "show-overflow-tooltip": true }), a(s, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": true }), a(s, { prop: m.weightStatus === o(b).NET.V ? "totalNetWeight" : "totalGrossNetWeight", label: "发运量（kg）", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: p }) => [w("span", null, H(m.weightStatus === o(b).NET.V ? p.totalNetWeight || "-" : p.totalGrossNetWeight || "-"), 1)]), _: 1 }, 8, ["prop"])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[P, r.value]]), a(z, { total: o(S), "current-page": o(g).pageNumber, "page-size": o(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(N), onCurrentChange: o(x) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512)), [[j, e.showType]]);
  };
} };
export {
  oe as default
};
