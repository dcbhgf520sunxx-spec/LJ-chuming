import { _ as k, kc as h, m4 as p, a3 as d } from "../../../../shared/runtime.js";
import { u as L } from "../../../../modules/use-product-lines-79a95221.js";
import { ref as m } from "vue";
import { watchEffect as v } from "vue";
import { watch as E } from "vue";
import { resolveComponent as g } from "vue";
import { unref as n } from "vue";
import { openBlock as w } from "vue";
import { createBlock as I } from "vue";
import { createCommentVNode as V } from "vue";
const b = { __name: "has-task-productLine-select", props: { projectId: { type: [Number, String] }, productType: { type: [Number, String], default: void 0 }, productionLineHasTaskApi: { type: Function, required: true } }, setup(f) {
  const a = f, { crud: t } = h(), { productLines: i } = L(), u = m([]), c = m([]), y = async (o) => {
    if (typeof a.productionLineHasTaskApi == "function" && t.query.manufactureType !== p.OUTSOURCE.V) try {
      let e;
      t.query.manufactureType === p.HOMEMADE.V ? e = a.productType : e = d.ASSEMBLE.V | d.MACHINE_PART.V;
      const r = await a.productionLineHasTaskApi({ projectId: a.projectId, productType: e });
      u.value = r.ids;
    } catch (e) {
      console.log(e);
    }
  };
  function _() {
    const o = i.value[0].workshopList;
    c.value = o.filter((e) => {
      var r, s;
      return (s = (r = e.productionLineList) == null ? void 0 : r.filter((T) => {
        var l;
        return (l = u.value) == null ? void 0 : l.includes(T.id);
      })) == null ? void 0 : s.length;
    });
  }
  return v(() => {
    var o;
    (o = i.value) != null && o.length && _();
  }), E([() => a.projectId, () => t.query.manufactureType], async ([o, e]) => {
    c.value = [], u.value = [], await y();
  }, { deep: true, immediate: true }), (o, e) => {
    const r = g("common-select");
    return n(t).query.manufactureType !== n(p).OUTSOURCE.V ? (w(), I(r, { key: 0, modelValue: n(t).query.workshopId, "onUpdate:modelValue": e[0] || (e[0] = (s) => n(t).query.workshopId = s), "data-structure": { key: "id", value: "id", label: "name" }, options: c.value, class: "filter-item", clearable: "", filterable: "", placeholder: "选择车间", type: "other", onChange: n(t).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : V("", true);
  };
} }, C = k(b, [["__scopeId", "data-v-af1159bb"]]);
export {
  C as default
};
