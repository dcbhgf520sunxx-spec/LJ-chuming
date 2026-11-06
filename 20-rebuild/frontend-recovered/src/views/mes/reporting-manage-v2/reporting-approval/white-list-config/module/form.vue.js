import { ref as n } from "vue";
import { computed as V } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as T } from "vue";
import { createBlock as x } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createTextVNode as v } from "vue";
import { ElFormItem as D } from "element-plus";
import { ElForm as U } from "element-plus";
import { ao as z, aV as q } from "../../../../../../shared/runtime.js";
import { g as E, a as F } from "../../../../../../modules/stud-set-1d850c87.js";
import { _ as O } from "../../../../../../modules/process-select-b35dffc0.js";
import { u as R } from "../../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const G = { __name: "form", setup(j) {
  const c = n(), p = n(), u = n(), { loaded: f, productionTeam: g } = R(), _ = { workshopIdList: void 0, processId: void 0, teamIdList: void 0 }, { crud: r, CRUD: I, form: e } = z(_, c), L = V(() => !e.workshopIdList || !e.processId ? [] : g.value.filter((t) => e.workshopIdList.includes(t.workshopId) && t.processId === e.processId)), b = { workshopIdList: [{ required: true, type: "array", message: "请选择车间", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], teamIdList: [{ required: true, message: "请选择班组", trigger: "change" }] };
  I.HOOK.beforeSubmit = () => {
    e.teamIds = e.teamIdList.join(","), e.workshopIds = e.workshopIdList.join(","), e.teamList = void 0, e.workshopList = void 0, e.process = void 0;
  }, (async () => {
    try {
      p.value = await E();
    } catch (t) {
      console.log(t);
    }
  })();
  const h = { ProductSectionNameEnum: 1, productClassificationEnum: 32, productType: 8 };
  return (async () => {
    try {
      const t = await F(h);
      u.value = t[0].sectionWarehouseConfigDTOList;
    } catch (t) {
      console.log(t);
    }
  })(), (t, s) => {
    const y = m("common-button"), d = D, w = m("common-select"), k = U, C = m("common-dialog");
    return T(), x(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(r).cancelCU, visible: o(r).status.cu > 0, title: o(r).status.title, width: "550px" }, { titleRight: l(() => [a(y, { loading: o(r).status.cu === 2, type: "primary", size: "default", onClick: o(r).submitCU }, { default: l(() => s[3] || (s[3] = [v("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: l(() => [a(k, { ref_key: "formRef", ref: c, model: o(e), rules: b, size: "default", "label-width": "100px" }, { default: l(() => [a(d, { label: "车间", prop: "workshopIdList" }, { default: l(() => [a(o(q), { modelValue: o(e).workshopIdList, "onUpdate:modelValue": s[0] || (s[0] = (i) => o(e).workshopIdList = i), placeholder: "选择车间", multiple: "", "collapse-tags": "", clearable: "", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 }), a(d, { label: "工序", prop: "processId" }, { default: l(() => [a(o(O), { modelValue: o(e).processId, "onUpdate:modelValue": s[1] || (s[1] = (i) => o(e).processId = i), size: "default", placeholder: "选择工序", filterable: "", clearable: "", multiple: false, style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 }), a(d, { label: "班组", prop: "teamIdList" }, { default: l(() => [a(w, { modelValue: o(e).teamIdList, "onUpdate:modelValue": s[2] || (s[2] = (i) => o(e).teamIdList = i), options: L.value, multiple: "", type: "other", dataStructure: { key: "id", label: "label", value: "id" }, size: "default", clearable: "", placeholder: "请选择班组", class: "filter-item", disabled: !o(f), style: { width: "300px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  G as default
};
