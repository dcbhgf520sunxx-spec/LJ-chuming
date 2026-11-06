import { ref as _ } from "vue";
import { computed as m } from "vue";
import { watch as C } from "vue";
import { ElMessage as f } from "element-plus";
import { openBlock as i } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as v } from "vue";
import { withCtx as T } from "vue";
import { Fragment as G } from "vue";
import { renderList as b } from "vue";
import { createBlock as p } from "vue";
import { resolveDynamicComponent as P } from "vue";
import { ElTabPane as A } from "element-plus";
import { ElTabs as F } from "element-plus";
import { dA as e, bv as k, G as t } from "../../../shared/runtime.js";
import { r as a } from "../../../modules/crm-c6ba92ff.js";
import R from "./table-module/firm-record.vue.js";
import K from "./table-module/government-record.vue.js";
import M from "./table-module/supplier-filing.vue.js";
import V from "./table-module/platform-registration.vue.js";
import d from "./table-module/project-information.vue.js";
import "./components/main-content.vue.js";
import "../../../modules/use-form-data-13311836.js";
import "../../../modules/project-information-053c195b.js";
import "./module/record-form.vue.js";
import "../../../modules/use-crm-basics-c35b230b.js";
import "../../../modules/use-crm-user-tree-f2f683a5.js";
import "../../../modules/use-crm-project-information-18afe991.js";
import "./components/firm-information-dialog.vue.js";
import "./components/form-box.vue.js";
import "../../../modules/region-cascader-39b54da2.js";
import "../../../modules/dept-cascader-6af417b9.js";
import "../../../modules/use-dept-b8e95315.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/basics-config-select-53b77c54.js";
import "./module/assignment-drawer.vue.js";
import "./components/UploadList.vue.js";
import "../../../modules/project-config-3fa4f850.js";
import "./module/project-follow-up.vue.js";
import "../../../modules/project-information-ad6c6e75.js";
import "./components/tabular-information.vue.js";
import "../components/information-description/index.vue.js";
const g = { class: "app-container" }, pe = { __name: "index", setup(D) {
  const o = _(e.FIRM_RECORD_CONFIG.K), r = _({}), E = m(() => {
    const l = [];
    return k.toArr(e).forEach((s) => {
      s.V !== e.PROJECT_TRACK_DOWN.V && s.V !== e.QUALIFICATION_REVIEW.V && s.V !== e.APPLICATION_TENDER.V && s.V !== e.PROJECT_GIVE_UP.V && l.push(s);
    }), l;
  }), O = m(() => {
    switch (o.value) {
      case e.FIRM_RECORD_CONFIG.K:
        return t(r.value.get) ? R : null;
      case e.GOVERNMENT_RECORD_CONFIG.K:
        return t(r.value.get) ? K : null;
      case e.SUPPLIER_INTO_RECORD_CONFIG.K:
        return t(r.value.get) ? M : null;
      case e.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
        return t(r.value.get) ? V : null;
      case e.PROJECT_SIGN_IN_CONFIG.K:
        return t(r.value.get) ? d : null;
      default:
        return t(r.value.get) ? R : null;
    }
  });
  function I() {
    switch (o.value) {
      case e.FIRM_RECORD_CONFIG.K:
        r.value = a.buiness;
        break;
      case e.GOVERNMENT_RECORD_CONFIG.K:
        r.value = a.goverment;
        break;
      case e.SUPPLIER_INTO_RECORD_CONFIG.K:
        r.value = a.supplier;
        break;
      case e.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
        r.value = a.registry;
        break;
      case e.PROJECT_SIGN_IN_CONFIG.K:
        r.value = a.check;
        break;
    }
    t(r.value.get);
  }
  return C(() => o.value, (l) => {
    switch (r.value = {}, l) {
      case e.FIRM_RECORD_CONFIG.K:
        r.value = a.buiness;
        break;
      case e.GOVERNMENT_RECORD_CONFIG.K:
        r.value = a.goverment;
        break;
      case e.SUPPLIER_INTO_RECORD_CONFIG.K:
        r.value = a.supplier;
        break;
      case e.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
        r.value = a.registry;
        break;
      case e.PROJECT_SIGN_IN_CONFIG.K:
        r.value = a.check;
        break;
    }
    if (!t(r.value.get)) {
      f.error("暂无权限");
      return;
    }
  }, { immediate: true }), (l, u) => {
    const s = A, N = F;
    return i(), c("div", g, [v(N, { modelValue: o.value, "onUpdate:modelValue": u[0] || (u[0] = (n) => o.value = n), onTabClick: I }, { default: T(() => [(i(true), c(G, null, b(E.value, (n) => (i(), p(s, { key: n.K, label: n.SL, name: n.K }, null, 8, ["label", "name"]))), 128))]), _: 1 }, 8, ["modelValue"]), (i(), p(P(O.value), { "tab-type": o.value, permission: r.value }, null, 8, ["tab-type", "permission"]))]);
  };
} };
export {
  pe as default
};
