import { ref as m } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as P } from "vue";
import { withModifiers as S } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as H } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as U, m as F } from "./module/detail.vue.js";
import { nb as I, x as L, mA as f, o as $, nc as h, G as q, P as z } from "../../../../shared/runtime.js";
import G from "./module/header.vue.js";
import "../../../../modules/common-ac6e385c.js";
import "../../../../modules/index-002b3f81.js";
import "./module/change-detail/reason.vue.js";
import "./module/change-detail/handle-info.vue.js";
import "../../../../modules/assemble-change-set-01d99287.js";
import "../../../../modules/machine-part-change-table-207fbedf.js";
import "./module/change-detail/assemble-rescheduling.vue.js";
import "../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../modules/artifact-f1b0ca44.js";
import "./module/change-detail/assemble-point-work-scheduling.vue.js";
const K = { class: "app-container" }, J = { class: "head-container" }, pe = { __name: "index", setup(Q) {
  const g = { add: false, edit: false, del: false, download: false }, y = m([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["changeReasonTypeEnum", ["parse-enum", I]]]), b = m(), { crud: p, columns: n, CRUD: k } = L({ title: "变更记录", sort: [], permission: { ...f }, optShow: { ...g }, invisibleColumns: [], crudApi: { ...U } }, b), { maxHeight: x } = $({ paginate: true }), v = m({}), d = m(false);
  k.HOOK.handleRefresh = (u, l) => {
    l.data.content = l.data.content.map((t) => t);
  };
  function E(u) {
    v.value = u, d.value = true;
  }
  return (u, l) => {
    const t = A, T = H, R = _("common-button"), C = _("common-table"), D = V("permission"), N = O;
    return o(), j("div", K, [B("div", J, [r(e(G))]), w((o(), a(C, { ref_key: "tableRef", ref: b, data: e(p).data, "empty-text": e(p).emptyText, "data-format": y.value, "max-height": e(x), style: { width: "100%" } }, { default: c(() => [r(t, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("serialNumber") ? (o(), a(t, { key: 0, "show-overflow-tooltip": "", label: "变更编号", prop: "serialNumber", align: "center", "min-width": "100" })) : i("", true), e(n).visible("project") ? (o(), a(t, { key: 1, "show-overflow-tooltip": "", label: "变更项目", prop: "project", "min-width": "150" })) : i("", true), e(n).visible("changeReasonTypeEnum") ? (o(), a(t, { key: 2, "show-overflow-tooltip": "", label: "变更原因", prop: "changeReasonTypeEnum", align: "center", "min-width": "100" })) : i("", true), e(n).visible("user.name") ? (o(), a(t, { key: 3, "show-overflow-tooltip": "", label: "变更提交人", prop: "user.name", align: "center", width: "120" })) : i("", true), e(n).visible("createTime") ? (o(), a(t, { key: 4, "show-overflow-tooltip": "", label: "变更时间", prop: "createTime", align: "center", width: "170" })) : i("", true), e(n).visible("confirmName") ? (o(), a(t, { key: 5, "show-overflow-tooltip": "", label: "生产确认人", prop: "confirmName", align: "center", width: "120" })) : i("", true), e(n).visible("confirmTime") ? (o(), a(t, { key: 6, "show-overflow-tooltip": "", label: "确认时间", prop: "confirmTime", align: "center", width: "170" })) : i("", true), e(n).visible("statusEnum") ? (o(), a(t, { key: 7, "show-overflow-tooltip": "", label: "状态", prop: "statusEnum", align: "center", width: "100" }, { default: c(({ row: s }) => [s.statusEnum ? (o(), a(T, { key: 0, effect: "plain", type: e(h).V[s.statusEnum].T }, { default: c(() => [M(P(e(h).VL[s.statusEnum]), 1)]), _: 2 }, 1032, ["type"])) : i("", true)]), _: 1 })) : i("", true), e(q)(e(f).detail) ? (o(), a(t, { key: 8, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: c(({ row: s }) => [w(r(R, { size: "default", type: "primary", disabled: s.statusEnum === e(h).CONFIRMED.V, icon: "el-icon-view", onClick: S((W) => E(s), ["stop"]) }, null, 8, ["disabled", "onClick"]), [[D, e(f).detail]])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[N, e(p).loading]]), r(e(z)), r(e(F), { visible: d.value, "onUpdate:visible": l[0] || (l[0] = (s) => d.value = s), info: v.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  pe as default
};
