import { ref as N } from "vue";
import { useRoute as V } from "vue-router";
import { resolveComponent as x } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as g } from "vue";
import { unref as a } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as r } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as H } from "vue";
import { withModifiers as L } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElTag as B } from "element-plus";
import { vLoading as E } from "element-plus";
import { c as K } from "../../../../modules/index-d532b8ca.js";
import { x as M, mV as D, o as Q, A as k, G as z, P as F } from "../../../../shared/runtime.js";
import G from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const $ = { class: "app-container" }, J = { class: "head-container" }, ye = { __name: "index", setup(W) {
  const O = { add: false, edit: false, del: false, download: false }, T = N(), b = N(false), v = N(), d = V(), { crud: h, columns: n, CRUD: q } = M({ title: "质量问题统计", permission: { ...D }, invisibleColumns: [], optShow: { ...O }, crudApi: { ...K }, hasPagination: true }, T), R = N([["createTime", "parse-time"], ["rectifyTime", "parse-time"], ["forfeit", ["to-fixed-ck", "YUAN"]]]), { maxHeight: C } = Q({ paginate: true });
  q.HOOK.handleRefresh = (m, c) => {
    var o;
    c.data.content = c.data.content.map((t) => {
      var y, w, _, e;
      return t.qualityTypeListStr = t.qualityTypeList && t.qualityTypeList.join("、"), t.imgUrls = t.attachmentDTOS && t.attachmentDTOS.map((f) => f.imageUrl), t.qhseRectifyDTOS && t.qhseRectifyDTOS.length && (t.rectifyName = (y = t.qhseRectifyDTOS[0]) == null ? void 0 : y.name, t.rectifyTime = (w = t.qhseRectifyDTOS[0]) == null ? void 0 : w.createTime, t.rectifyAttachmentDTOS = (_ = t.qhseRectifyDTOS[0]) == null ? void 0 : _.attachmentDTOS, t.rectifyImgUrls = t.rectifyAttachmentDTOS && t.rectifyAttachmentDTOS.map((f) => f.imageUrl), t.rectifyRemark = (e = t.qhseRectifyDTOS[0]) == null ? void 0 : e.remark), t.number && !Array.isArray(t.number) && (t.number = [t.number]), t;
    }), (o = d.params) != null && o.qhseId && (b.value = true, v.value = c.data.content[0]);
  }, q.HOOK.beforeToQuery = () => {
    var m, c, o;
    (m = d.params) != null && m.qhseId ? h.query.qhseId = (c = d.params) == null ? void 0 : c.qhseId : console.log(d.params, (o = d.params) == null ? void 0 : o.qhseId);
  };
  function I() {
    var m;
    (m = d.params) != null && m.qhseId && (h.query.qhseId = void 0, d.params.qhseId = void 0, console.log(d.params), h.toQuery());
  }
  function A(m) {
    b.value = true, v.value = m;
  }
  return (m, c) => {
    const o = j, t = B, y = x("common-button"), w = x("common-table"), _ = E;
    return l(), U("div", $, [u("div", J, [g(a(G))]), P((l(), r(w, { ref_key: "tableRef", ref: T, data: a(h).data, "empty-text": a(h).emptyText, "data-format": R.value, "max-height": a(C), "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [g(o, { label: "序号", type: "index", align: "center", width: "60" }), a(n).visible("qhseNumber") ? (l(), r(o, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "qhseNumber", label: "质检编号", width: "120px" }, { default: i(({ row: e }) => [u("span", null, p(e.qhseNumber), 1)]), _: 1 })) : s("", true), a(n).visible("serialNumber") ? (l(), r(o, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "serialNumber", label: "项目", width: "240px" }, { default: i(({ row: e }) => {
      var f, S;
      return [u("span", null, p((f = e == null ? void 0 : e.project) == null ? void 0 : f.serialNumber) + " " + p((S = e == null ? void 0 : e.project) == null ? void 0 : S.shortName), 1)];
    }), _: 1 })) : s("", true), a(n).visible("productSerialNumber") ? (l(), r(o, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "productSerialNumber", label: "编号", width: "120px" }, { default: i(({ row: e }) => [u("span", null, p(e.productSerialNumber), 1)]), _: 1 })) : s("", true), a(n).visible("processName") ? (l(), r(o, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "processName", label: "工序" }, { default: i(({ row: e }) => [u("span", null, p(e.processName), 1)]), _: 1 })) : s("", true), a(n).visible("userName") ? (l(), r(o, { key: 4, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "质检人" }, { default: i(({ row: e }) => [u("span", null, p(e.userName), 1)]), _: 1 })) : s("", true), a(n).visible("createTime") ? (l(), r(o, { key: 5, "show-overflow-tooltip": true, align: "center", prop: "createTime", label: "质检日期", "min-width": "120px" }, { default: i(({ row: e }) => [u("span", null, p(e.createTime), 1)]), _: 1 })) : s("", true), a(n).visible("dutyName") ? (l(), r(o, { key: 6, "show-overflow-tooltip": true, align: "center", prop: "dutyName", label: "责任人" }, { default: i(({ row: e }) => [u("span", null, p(e.dutyName), 1)]), _: 1 })) : s("", true), a(n).visible("workshopName") ? (l(), r(o, { key: 7, "show-overflow-tooltip": true, align: "center", prop: "workshopName", label: "车间" }, { default: i(({ row: e }) => [u("span", null, p(e.workshopName), 1)]), _: 1 })) : s("", true), a(n).visible("levelOneName") ? (l(), r(o, { key: 8, "show-overflow-tooltip": true, align: "center", prop: "levelOneName", label: "质量分类", width: "120px" }, { default: i(({ row: e }) => [u("span", null, p(e.levelOneName), 1)]), _: 1 })) : s("", true), a(n).visible("levelTwoName") ? (l(), r(o, { key: 9, "show-overflow-tooltip": true, align: "center", prop: "levelTwoName", label: "子类" }, { default: i(({ row: e }) => [u("span", null, p(e.levelTwoName), 1)]), _: 1 })) : s("", true), a(n).visible("behaviorScore") ? (l(), r(o, { key: 10, "show-overflow-tooltip": true, align: "center", prop: "behaviorScore", label: "扣分" }, { default: i(({ row: e }) => [u("span", null, p(e.behaviorScore), 1)]), _: 1 })) : s("", true), a(n).visible("penalty") ? (l(), r(o, { key: 11, "show-overflow-tooltip": true, align: "center", prop: "penalty", label: "处罚" }, { default: i(({ row: e }) => [u("span", null, p(e.penalty), 1)]), _: 1 })) : s("", true), a(n).visible("userName") ? (l(), r(o, { key: 12, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "状态" }, { default: i(({ row: { sourceRow: e } }) => [a(k).VK[e.status] ? (l(), r(t, { key: 0, type: a(k).V[e.status].T }, { default: i(() => [H(p(a(k).VL[e.status]), 1)]), _: 2 }, 1032, ["type"])) : s("", true)]), _: 1 })) : s("", true), a(n).visible("userName") ? (l(), r(o, { key: 13, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "操作" }, { default: i(({ row: e }) => [a(z)(a(D).detail) ? (l(), r(y, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: L((f) => A(e), ["stop"]) }, null, 8, ["onClick"])) : s("", true)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[_, a(h).loading]]), g(a(F)), g(a(Y), { visible: b.value, "onUpdate:visible": c[0] || (c[0] = (e) => b.value = e), "detail-data": v.value, onDetailClose: I }, null, 8, ["visible", "detail-data"])]);
  };
} };
export {
  ye as default
};
