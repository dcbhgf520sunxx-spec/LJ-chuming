import { ref as j } from "vue";
import { watch as D } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as t } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as f } from "vue";
import { withDirectives as x } from "vue";
import { unref as e } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as P } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as A } from "../../../../../../../modules/area-ca564e60.js";
import { _ as E, x as N, o as K, p as z, G as F, an as L, P as M } from "../../../../../../../shared/runtime.js";
import { a as Q } from "../../../../../../../modules/enclosure-365a2177.js";
import U from "./form.vue.js";
const W = { __name: "index", props: { detailInfo: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false } }, emits: ["success"], setup(d, { emit: w }) {
  const s = Q.plan, y = w, k = { add: true, edit: false, del: false, download: false }, p = d, g = j(), { CRUD: m, crud: a } = N({ title: "批次计划", sort: [], permission: { ...s }, optShow: { ...k }, crudApi: { ...A }, requiredQuery: ["projectId", "category"], hasPagination: true }, g), { maxHeight: v } = K({ wrapperBox: ".plan-form", paginate: true, extraHeight: 40 });
  return D(() => p.currentRow, (i) => {
    var o, c;
    i && (a.query.category = (o = p.currentRow) == null ? void 0 : o.category, a.query.projectId = (c = p.currentRow) == null ? void 0 : c.projectId, a.toQuery());
  }, { deep: true, immediate: true }), m.HOOK.handleRefresh = (i, o) => {
  }, m.HOOK.afterSubmit = (i, o) => {
    y("success");
  }, m.HOOK.afterDelete = (i, o) => {
    y("success");
  }, (i, o) => {
    const c = S, R = b("common-button"), r = T, C = b("common-table"), O = q("permission"), I = V;
    return u(), B("div", null, [_("div", null, [t(c, { type: "success", size: "large", style: { "margin-right": "10px" } }, { default: l(() => [H(f(d.currentRow.projectContent), 1)]), _: 1 }), x(t(R, { size: "default", icon: "el-icon-plus", type: "primary", onClick: e(a).toAdd }, null, 8, ["onClick"]), [[O, e(s).add]])]), x((u(), h(C, { ref_key: "tableRef", ref: g, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(v), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: l(() => [t(r, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(r, { key: "name", prop: "name", label: "批次", align: "center" }), t(r, { key: "quantityWork", prop: "quantityWork", label: "工程量", align: "center" }), t(r, { key: "date", prop: "date", label: "交货日期", align: "center" }, { default: l((n) => [_("div", null, f(n.row.date ? e(z)(n.row.date, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(r, { key: "remark", prop: "remark", label: "备注", align: "center" }, { default: l((n) => [_("div", null, f(n.row.remark || "-"), 1)]), _: 1 }), e(F)([...e(s).edit, ...e(s).del]) ? (u(), h(r, { key: 0, label: "操作", width: "190px", align: "center" }, { default: l((n) => [t(e(L), { data: n.row, permission: e(s) }, null, 8, ["data", "permission"])]), _: 1 })) : P("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[I, e(a).loading]]), t(e(U), { detailInfo: d.detailInfo }, null, 8, ["detailInfo"]), t(e(M))]);
  };
} }, $ = E(W, [["__scopeId", "data-v-84735b62"]]);
export {
  $ as default
};
