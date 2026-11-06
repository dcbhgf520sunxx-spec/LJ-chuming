import { ref as p } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as a } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as P } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as R, _ as U } from "./module/detail.vue.js";
import { i as h } from "../../../../modules/enclosure-365a2177.js";
import { t as M, D as g, x as O, o as V, G as q, P as B, ba as H } from "../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
const I = { class: "app-container" }, W = { __name: "index", setup(Y) {
  const { decimalPrecision: y } = M(), k = { add: false, edit: false, del: false, download: false }, _ = p(), u = p(false), b = p({}), w = p([["project", "parse-project"], ["totalLength", ["to-fixed", g.MES_ENCLOSURE_L__M]], ["price", ["to-fixed-ck", "YUAN"]], ["totalAmount", ["to-fixed-ck", "YUAN"]]]);
  function x(s) {
    return H(s, { props: [["totalAmount", y.value.enclosure], ["totalLength", g.MES_ENCLOSURE_L__M]] });
  }
  const { CRUD: L, crud: r, columns: l } = O({ title: "班组产量", sort: [], permission: { ...h }, optShow: { ...k }, crudApi: { ...R } }, _), { maxHeight: A } = V({ paginate: true });
  function C(s) {
    u.value = true, b.value = { ...s, startTime: r.query.startTime, endTime: r.query.endTime };
  }
  return L.HOOK.handleRefresh = async (s, { data: i }) => {
    i.content.forEach((e) => {
      var m;
      e.totalLength = (e.totalLength || 0) / 1e3, e.totalAmount = (e.price || 0) * e.totalLength, e.projectId = (m = e.project) == null ? void 0 : m.id;
    });
  }, (s, i) => {
    const e = S, m = v("common-button"), N = v("common-table"), E = T;
    return o(), j("div", I, [c(t($), { class: "head-container" }), D((o(), a(N, { ref_key: "tableRef", ref: _, data: t(r).data, "empty-text": t(r).emptyText, "max-height": t(A), "data-format": w.value, "show-summary": "", "summary-method": x }, { default: f(() => [c(e, { label: "序号", type: "index", align: "center", width: "60" }), t(l).visible("project") ? (o(), a(e, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "center" })) : n("", true), t(l).visible("workshop.name") ? (o(), a(e, { key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": "", label: "车间", align: "center" })) : n("", true), t(l).visible("line.name") ? (o(), a(e, { key: "line.name", prop: "line.name", "show-overflow-tooltip": "", label: "生产线", align: "center" })) : n("", true), t(l).visible("LeaderName") ? (o(), a(e, { key: "LeaderName", prop: "LeaderName", "show-overflow-tooltip": true, label: "班组", align: "center" })) : n("", true), t(l).visible("totalLength") ? (o(), a(e, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": true, label: "产量(米)", align: "center" })) : n("", true), t(l).visible("price") ? (o(), a(e, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "工资单价", align: "center" })) : n("", true), t(l).visible("totalAmount") ? (o(), a(e, { key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: "总额", align: "center" })) : n("", true), t(q)([...t(h).detail]) ? (o(), a(e, { key: 7, label: "操作", width: "80px", align: "center", fixed: "right" }, { default: f(({ row: d }) => [c(m, { size: "default", type: "primary", onClick: (z) => C(d) }, { default: f(() => i[1] || (i[1] = [P("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[E, t(r).loading]]), c(t(B)), c(t(U), { visible: u.value, "onUpdate:visible": i[0] || (i[0] = (d) => u.value = d), info: b.value, permission: t(h) }, null, 8, ["visible", "info", "permission"])]);
  };
} };
export {
  W as default
};
