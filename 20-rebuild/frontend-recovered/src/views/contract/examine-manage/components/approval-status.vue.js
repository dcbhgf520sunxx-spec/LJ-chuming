import { inject as m } from "vue";
import { ref as n } from "vue";
import { watchEffect as d } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as e } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as g } from "vue";
import { unref as y } from "vue";
import { createCommentVNode as h } from "vue";
import { ElTableColumn as w } from "element-plus";
import { dp as T, iI as C, iJ as D, ec as E } from "../../../../shared/runtime.js";
const k = { key: 0, class: "approval-container" }, V = { __name: "approval-status", setup(A) {
  const l = m("tableItemData"), r = n([]), p = n(), c = async () => {
    try {
      const t = await D(l.id);
      t.forEach((a) => {
        a.approveResult === 1 ? a.type = "warning" : a.approveResult === 2 ? a.type = "success" : a.type = "danger";
      }), r.value = E(t, [], true);
    } catch (t) {
      console.error("获取审批流程失败:/api/contract/audit/getAudit", t);
    }
  };
  return d(() => {
    l.id && c();
  }), (t, a) => {
    const o = w, i = _("common-table");
    return r.value.length ? (f(), v("div", k, [e(T, { "header-title": "审批状态" }), e(i, { ref_key: "tableRef", ref: p, data: r.value }, { default: s(() => [e(o, { align: "center", label: "节点" }, { default: s(({ row: u }) => [b("span", null, g(y(C).VL[u.approveType]), 1)]), _: 1 }), e(o, { align: "center", label: "关联审批人", prop: "userName" }), e(o, { align: "center", label: "到达时间", prop: "arriveTime" }), e(o, { align: "center", label: "处理时间", prop: "approveTime" }), e(o, { align: "center", label: "处理意见", prop: "approveOpinion" })]), _: 1 }, 8, ["data"])])) : h("", true);
  };
} };
export {
  V as default
};
