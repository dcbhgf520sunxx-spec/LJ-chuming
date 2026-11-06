import { ref as _ } from "vue";
import { computed as V } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as j } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as $ } from "../../../../modules/enclosure-change-log-d4bf065e.js";
import { _ as M, x as q, mC as x, o as z, i as b, P as F } from "../../../../shared/runtime.js";
import { a as k } from "../../../../modules/plan-d12d7ccf.js";
import I from "./module/header.vue.js";
import K from "./module/detail.vue.js";
import "../../../../modules/artifact-change-log-d1afb1ca.js";
import "../../../../modules/change-reason-select-73e53277.js";
const Q = { class: "app-container" }, G = { class: "head-container" }, J = { __name: "index", setup(W) {
  const N = { add: false, edit: false, del: false, download: false }, g = _(), w = _({}), f = _(false), { crud: u, columns: s, CRUD: C } = q({ title: "构件变更记录", sort: [], permission: { ...k }, optShow: { ...N }, crudApi: { ...$ }, invisibleColumns: [""], hasPagination: true }, g), S = V(() => [["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["checkStatus", ["parse-enum", x]]]), { maxHeight: T } = z({ wrapperBox: ".artifactChangeLog", paginate: true, extraHeight: 40 });
  C.HOOK.handleRefresh = (m, { data: p }) => {
    p.content.map((e) => {
      const o = [];
      b(e.delArtifactList) && e.delArtifactList.forEach((a) => {
        o.includes(a.serialNumber) || o.push(a.serialNumber);
      }), b(e.updateArtifactList) && e.updateArtifactList.forEach((a) => {
        o.includes(a.serialNumber) || o.push(a.serialNumber);
      }), b(e.artifactBasicUpdateDTOList) && e.artifactBasicUpdateDTOList.forEach((a) => {
        o.includes(a.serialNumber) || o.push(a.serialNumber);
      }), e.changeSerialNumber = o.map((a) => `【${a}】`);
    });
  };
  function R(m) {
    w.value = m == null ? void 0 : m.sourceRow, f.value = true;
  }
  return (m, p) => {
    const e = H, o = O, a = y("common-button"), D = y("common-table"), L = P;
    return r(), A("div", Q, [B("div", G, [l(t(I))]), U((r(), i(D, { ref_key: "tableRef", ref: g, data: t(u).data, "empty-text": t(u).emptyText, "max-height": t(T), "data-format": S.value, style: { width: "100%" } }, { default: d(() => [l(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s).visible("project") ? (r(), i(e, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left", "min-width": "140" })) : n("", true), t(s).visible("monomer.name") ? (r(), i(e, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "left" })) : n("", true), t(s).visible("createTime") ? (r(), i(e, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "变更日期", align: "center" })) : n("", true), t(s).visible("serialNumber") ? (r(), i(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "变更编号", "min-width": "100", align: "left" })) : n("", true), t(s).visible("user.name") ? (r(), i(e, { key: "user.name", prop: "user.name", "show-overflow-tooltip": true, label: "发起人", align: "center" })) : n("", true), t(s).visible("checkUserName") ? (r(), i(e, { key: "checkUserName", prop: "checkUserName", "show-overflow-tooltip": "", label: "审核人", align: "center" })) : n("", true), t(s).visible("checkStatus") ? (r(), i(e, { key: "checkStatus", prop: "checkStatus", "show-overflow-tooltip": true, label: "状态", width: "100", align: "center" }, { default: d((c) => {
      var h, v;
      return [l(o, { type: (v = t(x).V[(h = c.row.sourceRow) == null ? void 0 : h.checkStatus]) == null ? void 0 : v.T }, { default: d(() => [E(j(c.row.checkStatus), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : n("", true), l(e, { label: "操作", width: "120", align: "center", fixed: "right" }, { default: d((c) => [l(a, { type: "primary", icon: "el-icon-view", size: "default", onClick: (h) => R(c.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[L, t(u).loading]]), l(t(F)), l(t(K), { modelValue: f.value, "onUpdate:modelValue": p[0] || (p[0] = (c) => f.value = c), currentRow: w.value, onSuccess: t(u).toQuery, permission: t(k) }, null, 8, ["modelValue", "currentRow", "onSuccess", "permission"])]);
  };
} }, ie = M(J, [["__scopeId", "data-v-d7b5681e"]]);
export {
  ie as default
};
