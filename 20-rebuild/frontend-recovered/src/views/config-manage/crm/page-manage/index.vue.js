import { ref as s } from "vue";
import { onMounted as T } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as o } from "vue";
import { withCtx as m } from "vue";
import { unref as u } from "vue";
import { createBlock as g } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as b } from "vue";
import { ElTableColumn as A } from "element-plus";
import { g as G } from "../components/table-config-card.vue.js";
import { G as I, dB as E, bv as M, dA as e } from "../../../../shared/runtime.js";
import k from "./module/record-config-drawer.vue.js";
import "../../../../modules/project-config-3fa4f850.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
import "./detail/record-page.vue.js";
const D = { class: "app-container" }, h = { __name: "index", setup(F) {
  const i = s([]), _ = s(false), a = s({});
  T(() => {
    d();
  });
  const N = s([["finallyUpdateTime", "parse-time"]]);
  async function d() {
    if (!I(E.get)) return;
    const l = await G(), t = M.toArr(e);
    i.value = l.map((n) => (t.forEach((r) => {
      n.crmPageManagementConfigEnum === r.V && (n.detailType = r.TYPE);
    }), n)), console.log(i.value);
  }
  function O(l) {
    switch (l.crmPageManagementConfigEnum) {
      case e.FIRM_RECORD_CONFIG.V:
        a.value = e.FIRM_RECORD_CONFIG;
        break;
      case e.GOVERNMENT_RECORD_CONFIG.V:
        a.value = e.GOVERNMENT_RECORD_CONFIG;
        break;
      case e.SUPPLIER_INTO_RECORD_CONFIG.V:
        a.value = e.SUPPLIER_INTO_RECORD_CONFIG;
        break;
      case e.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V:
        a.value = e.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT;
        break;
      case e.PROJECT_SIGN_IN_CONFIG.V:
        a.value = e.PROJECT_SIGN_IN_CONFIG;
        break;
      case e.PROJECT_TRACK_DOWN.V:
        a.value = e.PROJECT_TRACK_DOWN;
        break;
      case e.QUALIFICATION_REVIEW.V:
        a.value = e.QUALIFICATION_REVIEW;
        break;
      case e.APPLICATION_TENDER.V:
        a.value = e.APPLICATION_TENDER;
        break;
      case e.PROJECT_GIVE_UP.V:
        a.value = e.PROJECT_GIVE_UP;
        break;
    }
    _.value = true;
  }
  function p() {
    d();
  }
  return (l, t) => {
    const n = A, r = R("common-button"), f = R("common-table");
    return C(), P("div", D, [t[2] || (t[2] = V("div", { class: "head-container" }, null, -1)), o(f, { data: i.value, "data-format": N.value }, { default: m(() => [o(n, { type: "index", label: "序号", align: "center", width: "80" }), o(n, { label: "表单", align: "center", prop: "crmPageManagementConfigEnumName" }), o(n, { label: "最后更新", prop: "finallyUpdateTime", align: "center" }), u(I)(u(E).edit) ? (C(), g(n, { key: 0, label: "操作", align: "center" }, { default: m(({ row: c }) => [o(r, { type: "primary", size: "default", onClick: (L) => O(c) }, { default: m(() => t[1] || (t[1] = [v("编辑")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "data-format"]), o(k, { modelValue: _.value, "onUpdate:modelValue": t[0] || (t[0] = (c) => _.value = c), title: a.value.L, "row-value": a.value.V, permission: u(E).detail, "detail-info": a.value, onSuccess: p }, null, 8, ["modelValue", "title", "row-value", "permission", "detail-info"])]);
  };
} };
export {
  h as default
};
