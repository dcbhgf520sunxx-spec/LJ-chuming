import { inject as v } from "vue";
import { ref as a } from "vue";
import { provide as l } from "vue";
import { computed as i } from "vue";
import { reactive as _ } from "vue";
import { watch as E } from "vue";
import { openBlock as I } from "vue";
import { createBlock as L } from "vue";
import { withCtx as c } from "vue";
import { createVNode as g } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as N } from "vue";
import { resolveDynamicComponent as H } from "vue";
import { nextTick as U } from "vue";
import { ElButton as $ } from "element-plus";
import { ElDrawer as q } from "element-plus";
import G from "./calculation/index.vue.js";
import J from "./reverse-thrust/index.vue.js";
import { dp as K, e2 as C, e6 as h } from "../../../../../shared/runtime.js";
import { d as Q, e as W, a as X } from "../../../../../modules/cutting-config-59e818a6.js";
import { a as Y, e as Z } from "../../../../../modules/project-cutting-config-562d5e35.js";
const ie = { __name: "index", setup(ee, { expose: x }) {
  const o = v("projectData"), s = a(false), u = a(false), d = a(""), S = a([]), D = a([]);
  l("saveList", D);
  const T = i(() => o ? Y : Q), j = i(() => o ? Z : W), r = _({ boolFixedPrice: true, machinePartType: null, statisticsMode: null, steelClassificationId: null }), n = _({ steelClassificationId: null, processIdList: [], detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] });
  l("validateList", S), l("reverSetFromData", r), l("calculationFormData", n);
  const k = v("headerData"), { radio: y } = k, M = v("parentData"), { tableRef: O } = M, f = a(null), A = i(() => y.value === 1 ? "下料配置 -【实时计算模式】" : "下料配置 -【入库倒推模式】"), p = a("40%"), F = [null, G, J], z = i(() => F[y.value]), m = a(null);
  E([() => r, () => n], ([e, t]) => {
    e.id || t.id ? d.value = "修改" : d.value = "创建", n.statisticsMode === 3 ? p.value = "45%" : p.value = "40%";
  }, { deep: true, immediate: true }), (async () => {
    try {
      const e = await X();
      e.id && (f.value = e.mode);
    } catch (e) {
      console.log(e);
    }
  })();
  const V = async () => {
    u.value = true;
    try {
      await Promise.all(D.value.map((t) => t()));
      const e = m.value.formData;
      if (f.value) e.statisticsConfigStatisticsMode = f.value;
      else return C("error", "请先前往统计配置页面配置模式");
      e.id ? (await j.value({ ...e, contractProjectId: o ? o.contractProjectId : null }), C("success", "修改成功")) : (await T.value({ ...e, contractProjectId: o ? o.contractProjectId : null }), C("success", "创建成功")), s.value = false, O.value.getSparePartsConfigList();
    } catch (e) {
      console.error("新增或修改失败;" + e);
    } finally {
      u.value = false;
    }
  }, R = async () => {
    s.value = false, await U(), h(r), h(n);
  };
  return x({ visible: s, reverSetFromData: r, currentComponentRef: m, calculationFormData: n }), (e, t) => {
    const w = $, B = q;
    return I(), L(B, { modelValue: s.value, "onUpdate:modelValue": t[1] || (t[1] = (P) => s.value = P), "close-on-click-modal": false, "close-on-press-escape": false, size: p.value, "destroy-on-close": "", "show-close": false, onClosed: R }, { header: c(() => [g(K, { "header-title": A.value, "type-one": false }, null, 8, ["header-title"]), g(w, { plain: "", onClick: t[0] || (t[0] = (P) => s.value = false) }, { default: c(() => t[2] || (t[2] = [b("关闭")])), _: 1, __: [2] }), g(w, { type: "success", onClick: V, loading: u.value }, { default: c(() => [b(N(d.value), 1)]), _: 1 }, 8, ["loading"])]), default: c(() => [(I(), L(H(z.value), { ref_key: "currentComponentRef", ref: m }, null, 512))]), _: 1 }, 8, ["modelValue", "size"]);
  };
} };
export {
  ie as default
};
