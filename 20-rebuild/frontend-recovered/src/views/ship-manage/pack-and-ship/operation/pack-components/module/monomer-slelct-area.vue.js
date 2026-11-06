import { _ as L, kc as k, m4 as q, nP as V } from "../../../../../../shared/runtime.js";
import { g as w } from "../../../../../../modules/artifact-62fe68f7.js";
import { u as x } from "../../../../../../modules/use-product-lines-79a95221.js";
import { ref as d } from "vue";
import { watchEffect as C } from "vue";
import { watch as S } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as E } from "vue";
import { unref as r } from "vue";
import { createBlock as j } from "vue";
import { createCommentVNode as A } from "vue";
import { createVNode as y } from "vue";
const U = { class: "head-container" }, N = { __name: "monomer-slelct-area", props: { projectId: { type: [Number, String] }, productType: { type: [Number, String], default: void 0 } }, setup(v) {
  const n = v, { crud: e } = k(), { productLines: m } = x(), l = d([]), i = d(false), u = d([]), c = d([]), p = d([]);
  function I(o) {
    const a = u.value.findIndex((t) => t.id === o);
    a !== -1 ? (l.value = u.value[a].areaSimpleList, l.value.length > 0 && l.value.forEach((t) => {
      t.customLabel = `${t.name} ( ${t.axis} )`;
    })) : (e.query.areaId = void 0, l.value = []);
  }
  async function g() {
    u.value = [], i.value = true;
    try {
      const { content: o = [] } = await V(n.projectId, { productType: n.mainProductType }) || {};
      u.value = o;
    } catch (o) {
      console.log("获取单体列表", o);
    } finally {
      i.value = false;
    }
  }
  const h = async (o) => {
    try {
      const a = await w({ projectId: n.projectId, productType: n.productType });
      c.value = a.ids;
    } catch (a) {
      console.log(a);
    }
  };
  function b() {
    const o = m.value[0].workshopList;
    p.value = o.flatMap((a) => a.productionLineList.filter((t) => c.value.includes(t.id)));
  }
  C(() => {
    var o;
    (o = m.value) != null && o.length && b();
  }), S(() => n.projectId, async (o) => {
    console.log(o), e.query.monomerId = void 0, e.query.areaId = void 0, e.query.productionLineId = void 0, p.value = [], c.value = [], await h(), await g(), e.toQuery();
  }, { deep: true, immediate: true });
  function _(o) {
    o ? I(o) : e.query.areaId = void 0, e.toQuery();
  }
  return (o, a) => {
    const t = T("common-select");
    return f(), E("div", U, [r(e).query.manufactureType !== r(q).OUTSOURCE.V ? (f(), j(t, { key: 0, modelValue: r(e).query.productionLineId, "onUpdate:modelValue": a[0] || (a[0] = (s) => r(e).query.productionLineId = s), "data-structure": { key: "id", value: "id", label: "name" }, options: p.value, class: "filter-item", clearable: "", filterable: "", placeholder: "选择车间", type: "other", onChange: r(e).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : A("", true), y(t, { modelValue: r(e).query.monomerId, "onUpdate:modelValue": a[1] || (a[1] = (s) => r(e).query.monomerId = s), dataStructure: { id: "id", value: "id", label: "name" }, loading: i.value, options: u.value, class: "filter-item", clearable: "", filterable: "", placeholder: "选择单体", type: "other", onChange: _ }, null, 8, ["modelValue", "loading", "options"]), y(t, { modelValue: r(e).query.areaId, "onUpdate:modelValue": a[2] || (a[2] = (s) => r(e).query.areaId = s), dataStructure: { key: "id", value: "id", label: "customLabel" }, disabled: !r(e).query.monomerId, options: l.value, class: "filter-item", clearable: "", filterable: "", placeholder: "选择区域", type: "other", onChange: r(e).toQuery }, null, 8, ["modelValue", "disabled", "options", "onChange"])]);
  };
} }, W = L(N, [["__scopeId", "data-v-02246bb1"]]);
export {
  W as default
};
