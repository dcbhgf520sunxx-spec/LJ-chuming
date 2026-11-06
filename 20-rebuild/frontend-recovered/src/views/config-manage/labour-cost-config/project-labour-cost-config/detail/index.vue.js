import { ref as c } from "vue";
import { computed as A } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as f } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { createVNode as V } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as I } from "vue";
import { unref as p } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { isRef as w } from "vue";
import { ElTag as E } from "element-plus";
import { ew as t, u as R } from "../../../../../shared/runtime.js";
import S from "../../cutting-config/index.vue.js";
import T from "../../group-welding-config/index.vue.js";
import k from "../../assembly-welding-config/index.vue.js";
import x from "../../stud-set/index.vue.js";
import "../../cutting-config/header.vue.js";
import "../../cutting-config/create/index.vue.js";
import "../../cutting-config/create/calculation/index.vue.js";
import "../../../../../modules/cutting-config-59e818a6.js";
import "../../cutting-config/create/reverse-thrust/index.vue.js";
import "../../../../../modules/project-cutting-config-562d5e35.js";
import "../../cutting-config/create/batch/index.vue.js";
import "../../cutting-config/table.vue.js";
import "../../group-welding-config/header.vue.js";
import "../../group-welding-config/create/index.vue.js";
import "../../group-welding-config/create/calculation/index.vue.js";
import "../../../../../modules/project-group-welding-config-ee2755b6.js";
import "../../group-welding-config/create/reverse-thrust/index.vue.js";
import "../../../../../modules/drilling-config-d5ae6cbb.js";
import "../../group-welding-config/create/batch/index.vue.js";
import "../../group-welding-config/table.vue.js";
import "../../assembly-welding-config/header.vue.js";
import "../../assembly-welding-config/create/index.vue.js";
import "../../assembly-welding-config/create/calculation/index.vue.js";
import "../../../../../modules/project-assembly-welding-config-107f9ee1.js";
import "../../assembly-welding-config/create/reverse-thrust/index.vue.js";
import "../../assembly-welding-config/create/batch/index.vue.js";
import "../../assembly-welding-config/table.vue.js";
import "../../../../../modules/stud-set-1d850c87.js";
import "../../stud-set/module/header.vue.js";
import "../../stud-set/module/form.vue.js";
const de = { __name: "index", props: { visible: { type: Boolean, default: false }, projectData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(i, { emit: _ }) {
  const s = i, r = c(t.MAKINGS.V), l = c(null), b = _, { visible: a, handleClose: g } = R({ emit: b, props: s, field: "visible", showHook: D }), v = A(() => {
    switch (r.value) {
      case t.MAKINGS.V:
        return S;
      case t.INSTALLED_WELDED.V:
        return T;
      case t.INSTALL_WELD.V:
        return k;
      case t.AUXILIARY_MATERIAL.V:
        return x;
      default:
        return;
    }
  });
  function D() {
    var m, e;
    r.value = t.MAKINGS.V, (e = (m = l.value) == null ? void 0 : m.tableRef) == null || e.getSparePartsConfigList(s.projectData.contractProjectId);
  }
  return (m, e) => {
    const L = E, j = u("component-radio-button"), y = u("common-drawer");
    return f(), d(y, { "append-to-body": "", ref: "drawerRef", title: "项目工价配置", modelValue: p(a), "onUpdate:modelValue": e[1] || (e[1] = (o) => w(a) ? a.value = o : null), direction: "rtl", "before-close": p(g), size: "100%" }, { titleAfter: n(() => [V(L, { size: "large" }, { default: n(() => {
      var o;
      return [C("项目名称：" + I(((o = i.projectData) == null ? void 0 : o.projectName) || "-"), 1)];
    }), _: 1 })]), content: n(() => [V(j, { class: "filter-item", modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => r.value = o), type: "enum", options: p(t).ENUM }, null, 8, ["modelValue", "options"]), (f(), d(N(v.value), { ref_key: "compRef", ref: l, projectData: i.projectData }, null, 8, ["projectData"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  de as default
};
