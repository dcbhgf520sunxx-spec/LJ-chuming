import { e as _ } from "../../../../modules/labor-setting-a0cbdb82.js";
import { m as M, mx as E, n as V } from "../../../../shared/runtime.js";
import { useStore as N } from "vuex";
import { ref as p } from "vue";
import { shallowRef as j } from "vue";
import { watch as f } from "vue";
import { ElMessageBox as v } from "element-plus";
import { resolveComponent as R } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as Y } from "vue";
import { createBlock as g } from "vue";
import { unref as B } from "vue";
import { resolveDynamicComponent as T } from "vue";
import u from "./by-monomer-and-area/index.vue.js";
import d from "./by-list/index.vue.js";
import "../../../../modules/project-19a12d6b.js";
import "./by-monomer-and-area/module/header.vue.js";
import "./by-list/module/create-drawer.vue.js";
import "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
import "./by-list/module/handle-confirm.vue.js";
import "../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const b = { class: "app-container" }, I = { class: "head-container" }, q = { __name: "index", setup(L) {
  const i = N(), t = p(), { globalProject: m, globalProjectId: r } = M(["globalProject", "globalProjectId"]), { projects: h } = E(), e = { BY_MONOMER_AND_AREA: { L: "根据单体区域创建", K: "BY_MONOMER_AND_AREA", V: 1 }, BY_LIST: { L: "根据清单创建", K: "BY_LIST", V: 2 } };
  V(e);
  const a = j(), n = p();
  return f(() => t.value, async (o) => {
    n.value ? (await i.dispatch("project/fetchUserProjects"), t.value = n.value, t.value === e.BY_MONOMER_AND_AREA.V ? a.value = u : t.value === e.BY_LIST.V && (a.value = d)) : o === e.BY_MONOMER_AND_AREA.V ? v.confirm(`您选择的为“${e.BY_MONOMER_AND_AREA.L}”模式创建劳务单位，一旦确认无法更换模式，是否确认？`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(async () => {
      a.value = u, await _({ divideMethod: e.BY_MONOMER_AND_AREA.V, projectId: r.value }), setTimeout(async () => {
        await i.dispatch("project/fetchUserProjects");
      }, 200);
    }).catch((s) => {
      t.value = void 0;
    }) : o === e.BY_LIST.V && v.confirm(`您选择的为“${e.BY_LIST.L}”模式创建劳务单位，一旦确认无法更换模式，是否确认？`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(async () => {
      a.value = d, await _({ divideMethod: e.BY_LIST.V, projectId: r.value }), setTimeout(async () => {
        await i.dispatch("project/fetchUserProjects");
      }, 200);
    }).catch((s) => {
      t.value = void 0;
    });
  }, { immediate: true }), f(() => m.value, async (o) => {
    var s, l;
    await i.dispatch("project/fetchUserProjects"), o ? (n.value = (l = (s = h.value) == null ? void 0 : s.find((c) => c.id === (o == null ? void 0 : o.id))) == null ? void 0 : l.installDivideMethod, t.value = n.value, t.value === e.BY_MONOMER_AND_AREA.V ? a.value = u : t.value === e.BY_LIST.V && (a.value = d)) : t.value = void 0;
  }, { immediate: true, deep: true }), (o, s) => {
    const l = R("common-radio-button");
    return A(), y("div", b, [O("div", I, [Y(l, { modelValue: t.value, "onUpdate:modelValue": s[0] || (s[0] = (c) => t.value = c), options: e.ENUM, type: "enum", size: "default", disabledVal: t.value === e.BY_MONOMER_AND_AREA.V ? [e.BY_LIST.V] : t.value === e.BY_LIST.V ? [e.BY_MONOMER_AND_AREA.V] : [], class: "filter-item", style: { "margin-right": "6px" } }, null, 8, ["modelValue", "options", "disabledVal"])]), (A(), g(T(t.value ? a.value : "undefined"), { globalProjectId: B(r), globalProject: B(m) }, null, 8, ["globalProjectId", "globalProject"]))]);
  };
} };
export {
  q as default
};
