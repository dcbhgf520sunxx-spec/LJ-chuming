import { ref as h } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as r } from "vue";
import { withCtx as t } from "vue";
import { normalizeClass as I } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as V } from "vue";
import { ElTableColumn as B } from "element-plus";
import { InfoFilled as H } from "@element-plus/icons-vue";
import { ElIcon as K } from "element-plus";
import { ElTooltip as M } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as z, _ as A } from "./module/header.vue.js";
import { _ as F, x as j, mY as S, o as q, P as L } from "../../../../shared/runtime.js";
import Y from "./detail/index.vue.js";
import "./detail/module/header.vue.js";
const G = { class: "app-container" }, J = { class: "head-container" }, Q = { style: { display: "inline-block" } }, W = { style: { display: "inline-block" } }, X = { __name: "index", setup(Z) {
  const C = { add: false, edit: false, del: false, download: false }, v = h(), g = h(false), y = h(), { crud: b, columns: d, CRUD: k } = j({ title: "抽检统计", permission: { ...S }, invisibleColumns: [], optShow: { ...C }, crudApi: { ...z }, hasPagination: true }, v), { maxHeight: R } = q({ paginate: true });
  k.HOOK.handleRefresh = (m, l) => {
    l.data.content = l.data.content.map((a, u) => (a.idx = u + 1, a.monomerSpotStatisticsCountDTOS.length && a.monomerSpotStatisticsCountDTOS.forEach((_, f) => {
      _.idx = f + 1;
    }), a.rowKey = a.id, a));
  };
  function D(m) {
    g.value = true, y.value = m;
  }
  return (m, l) => {
    const a = B, u = H, _ = K, f = M, P = x("common-button"), T = x("common-table"), N = O("permission"), E = $;
    return i(), U("div", G, [n("div", J, [s(o(A))]), w((i(), r(T, { ref_key: "tableRef", ref: v, data: o(b).data, "empty-text": o(b).emptyText, "data-format": m.dataFormat, "max-height": o(R), "row-key": "rowKey", "tree-props": { children: "monomerSpotStatisticsCountDTOS" }, "default-expand-all": "", style: { width: "100%" } }, { default: t(() => [s(a, { label: "序号", prop: "idx", align: "center", width: "55" }, { default: t(({ row: e }) => [n("span", { class: I([e.monomerSpotStatisticsCountDTOS ? "" : "child"]) }, p(e.idx), 3)]), _: 1 }), o(d).visible("name") ? (i(), r(a, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "name", label: "项目/单体名称" }, { default: t(({ row: e }) => [n("span", null, p(e.name || "-"), 1)]), _: 1 })) : c("", true), o(d).visible("spotCheckUserNames") ? (i(), r(a, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "spotCheckUserNames", label: "抽检人" }, { default: t(({ row: e }) => [n("span", null, p(e.spotCheckUserNames || "-"), 1)]), _: 1 })) : c("", true), o(d).visible("samplingPassRate") ? (i(), r(a, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "samplingPassRate", label: "抽检合格率" }, { header: t(() => [s(f, { class: "item", effect: "light", content: "合格率 = 抽检合格构件数量 / 项目（单体）下所有需要抽检（已完成）的构件类型下构件的总数 *100%", placement: "top" }, { default: t(() => [n("div", Q, [l[1] || (l[1] = n("span", { style: { "margin-left": "10px" } }, "抽检合格率", -1)), s(_, null, { default: t(() => [s(u)]), _: 1 })])]), _: 1 })]), default: t(({ row: e }) => [n("span", null, p(e.samplingPassRate) + "%", 1)]), _: 1 })) : c("", true), o(d).visible("unSamplingPassRate") ? (i(), r(a, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "unSamplingPassRate", label: "抽检不合格率" }, { default: t(({ row: e }) => [n("span", null, p(e.unSamplingPassRate) + "%", 1)]), _: 1 })) : c("", true), o(d).visible("samplingRate") ? (i(), r(a, { key: 4, "show-overflow-tooltip": true, align: "center", prop: "samplingRate", label: "抽检率" }, { header: t(() => [s(f, { class: "item", effect: "light", content: "合格率 = 抽检件数 / 项目（单体）完成构件总数 *100%", placement: "top" }, { default: t(() => [n("div", W, [l[2] || (l[2] = n("span", { style: { "margin-left": "10px" } }, "抽检率", -1)), s(_, null, { default: t(() => [s(u)]), _: 1 })])]), _: 1 })]), default: t(({ row: e }) => [n("span", null, p(e.samplingRate) + "%", 1)]), _: 1 })) : c("", true), s(a, { align: "center", label: "操作", fixed: "right" }, { default: t(({ row: e }) => [w((i(), r(P, { size: "default", type: "primary", onClick: (ee) => D(e) }, { default: t(() => l[3] || (l[3] = [V(" 详情 ")])), _: 2, __: [3] }, 1032, ["onClick"])), [[N, o(S).detail]])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[E, o(b).loading]]), s(o(L)), s(o(Y), { visible: g.value, "onUpdate:visible": l[0] || (l[0] = (e) => g.value = e), "detail-data": y.value }, null, 8, ["visible", "detail-data"])]);
  };
} }, se = F(X, [["__scopeId", "data-v-b1fa8d4c"]]);
export {
  se as default
};
