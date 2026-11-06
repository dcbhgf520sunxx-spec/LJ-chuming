import { ref as r } from "vue";
import { computed as c } from "vue";
import { provide as D } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as W } from "vue";
import { unref as s } from "vue";
import { createBlock as q } from "vue";
import { withCtx as _ } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as R } from "./detail/output-wage/index.vue.js";
import S from "./module/header.vue.js";
import { _ as L, o as O, x as P, q3 as T, D as f, ba as V } from "../../../../shared/runtime.js";
import $ from "./detail/index.vue.js";
import "./detail/output-wage/module/header.vue.js";
import "./detail/output-wage/module/update-record.vue.js";
import "./detail/hourly-worker/index.vue.js";
const E = { class: "app-container" }, F = { class: "head-container" }, H = { __name: "index", setup(I) {
  const g = { add: false, edit: false, del: false, download: false }, m = r(), l = r(false), p = r(), { maxHeight: y } = O({ paginate: false }), { crud: o } = P({ title: "工价报表", optShow: { ...g }, permission: { ...T }, crudApi: { ...R }, hasPagination: false }, m), v = c(() => [["totalWage", ["to-thousand", f.YUAN]]]);
  function b(t) {
    p.value = t, l.value = true;
  }
  D("query", o.query);
  const h = c(() => o.data.reduce((t, n) => t + n.totalWage, 0)), x = c(() => o.data.reduce((t, n) => t + n.inspectionQuantity, 0));
  function w(t) {
    return V(t, { props: [["totalWage", f.YUAN]], toThousandFields: ["totalWage"] });
  }
  return (t, n) => {
    const a = A, k = u("common-button"), N = u("common-table"), C = B;
    return d(), Q("div", E, [U("div", F, [e(S, { totalOutput: h.value, totalQuantity: x.value }, null, 8, ["totalOutput", "totalQuantity"])]), W((d(), q(N, { ref_key: "tableRef", ref: m, data: s(o).data, "empty-text": s(o).emptyText, "data-format": v.value, "max-height": s(y), "show-summary": "", "summary-method": w }, { default: _(() => [e(a, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), e(a, { label: "车间", prop: "workshopName", key: "workshopName", align: "center" }), e(a, { label: "工序", prop: "processName", key: "processName", align: "center" }), e(a, { label: "班组", prop: "teamLeaderUserName", key: "teamLeaderUserName", align: "center" }), e(a, { label: "数量", prop: "inspectionQuantity", key: "inspectionQuantity", align: "center" }), e(a, { label: "工价总额（元）", prop: "totalWage", key: "totalWage", align: "center" }), e(a, { label: "操作", width: "90px", align: "center", fixed: "right" }, { default: _((i) => [e(k, { icon: "el-icon-view", type: "primary", size: "default", onClick: (M) => b(i.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[C, s(o).loading]]), e($, { visible: l.value, "onUpdate:visible": n[0] || (n[0] = (i) => l.value = i), info: p.value }, null, 8, ["visible", "info"])]);
  };
} }, ee = L(H, [["__scopeId", "data-v-e0cafc4d"]]);
export {
  ee as default
};
