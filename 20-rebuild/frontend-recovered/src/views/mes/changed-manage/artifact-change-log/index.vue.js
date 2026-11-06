import { ref as _ } from "vue";
import { computed as L } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as r } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as j } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as $ } from "../../../../modules/artifact-change-log-d1afb1ca.js";
import { _ as M, x as q, n6 as k, mC as x, o as z, i as b, P as F } from "../../../../shared/runtime.js";
import I from "./module/header.vue.js";
import K from "./module/detail.vue.js";
import "../../../../modules/change-reason-select-73e53277.js";
import "../../../../modules/index-61ce89a1.js";
const Q = { class: "app-container" }, G = { class: "head-container" }, J = { __name: "index", setup(W) {
  const N = { add: false, edit: false, del: false, download: false }, g = _(), w = _({}), f = _(false), { crud: u, columns: i, CRUD: S } = q({ title: "变更审核", sort: [], permission: { ...k }, optShow: { ...N }, crudApi: { ...$ }, invisibleColumns: [""], hasPagination: true }, g), C = L(() => [["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["checkStatus", ["parse-enum", x]]]), { maxHeight: R } = z({ wrapperBox: ".artifactChangeLog", paginate: true, extraHeight: 40 });
  S.HOOK.handleRefresh = (m, { data: p }) => {
    p.content.map((e) => {
      const l = [];
      b(e.delArtifactList) && e.delArtifactList.forEach((a) => {
        l.includes(a.serialNumber) || l.push(a.serialNumber);
      }), b(e.updateArtifactList) && e.updateArtifactList.forEach((a) => {
        l.includes(a.serialNumber) || l.push(a.serialNumber);
      }), b(e.artifactBasicUpdateDTOList) && e.artifactBasicUpdateDTOList.forEach((a) => {
        l.includes(a.serialNumber) || l.push(a.serialNumber);
      }), e.changeSerialNumber = l.map((a) => `【${a}】`);
    });
  };
  function T(m) {
    w.value = m == null ? void 0 : m.sourceRow, f.value = true;
  }
  return (m, p) => {
    const e = H, l = O, a = y("common-button"), A = y("common-table"), D = P;
    return o(), V("div", Q, [B("div", G, [n(t(I))]), U((o(), r(A, { ref_key: "tableRef", ref: g, data: t(u).data, "empty-text": t(u).emptyText, "max-height": t(R), "data-format": C.value, style: { width: "100%" } }, { default: d(() => [n(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(i).visible("project") ? (o(), r(e, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left", "min-width": "140" })) : s("", true), t(i).visible("monomer.name") ? (o(), r(e, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "left" })) : s("", true), t(i).visible("createTime") ? (o(), r(e, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "变更日期", align: "center" })) : s("", true), t(i).visible("serialNumber") ? (o(), r(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "变更编号", "min-width": "100", align: "left" })) : s("", true), t(i).visible("user.name") ? (o(), r(e, { key: "user.name", prop: "user.name", "show-overflow-tooltip": true, label: "发起人", align: "center" })) : s("", true), t(i).visible("changeReason.name") ? (o(), r(e, { key: "changeReason.name", prop: "changeReason.name", "show-overflow-tooltip": true, label: "变更原因", align: "left" })) : s("", true), t(i).visible("changeSerialNumber") ? (o(), r(e, { key: "changeSerialNumber", prop: "changeSerialNumber", "show-overflow-tooltip": true, label: "涉及构件", "min-width": "100", align: "left" })) : s("", true), t(i).visible("checkUserName") ? (o(), r(e, { key: "checkUserName", prop: "checkUserName", "show-overflow-tooltip": "", label: "审核人", align: "center" })) : s("", true), t(i).visible("checkStatus") ? (o(), r(e, { key: "checkStatus", prop: "checkStatus", "show-overflow-tooltip": true, label: "状态", width: "100", align: "center" }, { default: d((c) => {
      var h, v;
      return [n(l, { type: (v = t(x).V[(h = c.row.sourceRow) == null ? void 0 : h.checkStatus]) == null ? void 0 : v.T }, { default: d(() => [E(j(c.row.checkStatus), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : s("", true), n(e, { label: "操作", width: "120", align: "center", fixed: "right" }, { default: d((c) => [n(a, { type: "primary", icon: "el-icon-view", size: "default", onClick: (h) => T(c.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[D, t(u).loading]]), n(t(F)), n(t(K), { modelValue: f.value, "onUpdate:modelValue": p[0] || (p[0] = (c) => f.value = c), currentRow: w.value, onSuccess: t(u).toQuery, permission: t(k) }, null, 8, ["modelValue", "currentRow", "onSuccess", "permission"])]);
  };
} }, re = M(J, [["__scopeId", "data-v-4d87f41a"]]);
export {
  re as default
};
