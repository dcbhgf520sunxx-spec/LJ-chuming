import { ref as l } from "vue";
import { inject as E } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as b } from "vue";
import { withCtx as y } from "vue";
import { createVNode as t } from "vue";
import { unref as c } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as N } from "element-plus";
import { _ as R, kc as U, o as I, eb as M, ec as S } from "../../../../../../shared/runtime.js";
import { u as $ } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { b as z } from "../../../../../../modules/detail-991649ef.js";
import A from "../../../common/components/record/file-download.vue.js";
const P = { class: "collection-container" }, j = { key: 1 }, G = { __name: "settle", setup(J, { expose: x }) {
  const i = l(false), { crud: k } = U(), { _commonFn: w, projectInfo: m } = E("tableItem"), { requestData: d, total: p, getSummaries: C } = $(false, { defineData: ["amount"] }), { maxHeight: T } = I({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), _ = l([]), n = async () => {
    var o;
    try {
      i.value = true;
      const { content: a, totalElements: e } = await z({ ...d, orderId: (o = m == null ? void 0 : m.value) == null ? void 0 : o.id, purchaseType: k.query.purchaseType });
      p.value = e, _.value = S(a);
    } catch (a) {
      console.log(a);
    } finally {
      i.value = false;
    }
  };
  n(), w.value.getCollectionRecordList = n;
  const u = l(false), f = l([]);
  function D(o) {
    f.value = o.attachments, u.value = true;
  }
  const q = l([["auditTime", ["parse-time", "{y}-{m}-{d}"]]]);
  return x({ getList: n }), (o, a) => {
    const e = H, L = h("common-button"), V = h("common-table"), B = N;
    return r(), v("div", P, [F((r(), b(V, { data: _.value, "data-format": q.value, "max-height": c(T), "summary-method": c(C), "show-summary": "", stripe: "" }, { default: y(() => [t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { align: "center", label: "创建时间", prop: "createTime" }), t(e, { align: "center", label: "结算金额", prop: "amount" }), t(e, { align: "center", label: "申请人", prop: "applyUserName" }), t(e, { align: "center", label: "审核人", prop: "auditUserName" }), t(e, { align: "center", label: "审核时间", prop: "auditTime" }), t(e, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: y(({ row: s }) => {
      var g;
      return [(g = s.attachments) != null && g.length ? (r(), b(L, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (K) => D(s) }, null, 8, ["onClick"])) : (r(), v("span", j, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "summary-method"])), [[B, i.value]]), t(M, { "request-data": c(d), total: c(p), onHandleChange: n }, null, 8, ["request-data", "total"]), t(A, { "file-list": f.value, modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (s) => u.value = s) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, Z = R(G, [["__scopeId", "data-v-7cf7f2f6"]]);
export {
  Z as default
};
