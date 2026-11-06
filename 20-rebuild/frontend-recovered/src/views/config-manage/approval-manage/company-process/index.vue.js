import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as o } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as C } from "element-plus";
import { x as R, ct as w, cu as A, o as D, cv as E, cw as P, G as V, an as B } from "../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import I from "./module/form.vue.js";
const L = { class: "app-container" }, U = { __name: "index", setup(O) {
  const _ = { add: true, edit: false, del: false, download: false }, d = h(), b = h([["updateTime", "parse-time"]]), { crud: m, columns: r, CRUD: v } = R({ title: "公司审批流程", sort: [], permission: { ...w }, optShow: { ..._ }, crudApi: { ...A }, invisibleColumns: [], hasPagination: false }, d), { maxHeight: x } = D();
  return v.HOOK.handleRefresh = (y, c) => {
    c.data.content = c.data.map((a) => {
      var i, n;
      return a.showName = (i = E.VL) == null ? void 0 : i[a.type], a.process = (n = a.approvers) == null ? void 0 : n.map((p) => {
        var u;
        return `【${(u = P) == null ? void 0 : u.VL[p.type]}：${p.userName}】`;
      }).join("→"), a;
    });
  }, (y, c) => {
    const a = T, i = g("common-table"), n = C;
    return t(), k("div", L, [l(e(H), { class: "head-container" }), N((t(), o(i, { ref_key: "tableRef", ref: d, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(x), "data-format": b.value, "return-source-data": "", style: { width: "100%" } }, { default: f(() => [l(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(r).visible("showName") ? (t(), o(a, { key: "showName", prop: "showName", "show-overflow-tooltip": "", label: "审批类型", "min-width": "160" })) : s("", true), e(r).visible("approveInfoName") ? (t(), o(a, { key: "approveInfoName", prop: "approveInfoName", "show-overflow-tooltip": "", label: "审批名称", "min-width": "160" })) : s("", true), e(r).visible("process") ? (t(), o(a, { key: "process", prop: "process", "show-overflow-tooltip": "", label: "审批流程", "min-width": "260" })) : s("", true), e(r).visible("updateTime") ? (t(), o(a, { key: "updateTime", prop: "updateTime", "show-overflow-tooltip": "", label: "更新时间", align: "center", "min-width": "130" })) : s("", true), e(V)(e(w).edit) ? (t(), o(a, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: f((p) => [l(e(B), { data: p.row }, null, 8, ["data"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[n, e(m).loading]]), l(e(I))]);
  };
} };
export {
  U as default
};
