import { inject as f } from "vue";
import { ref as a } from "vue";
import { computed as i } from "vue";
import { reactive as w } from "vue";
import { provide as v } from "vue";
import { watch as R } from "vue";
import { openBlock as y } from "vue";
import { createBlock as h } from "vue";
import { withCtx as c } from "vue";
import { createVNode as g } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as B } from "vue";
import { resolveDynamicComponent as E } from "vue";
import { ElButton as G } from "element-plus";
import { ElDrawer as J } from "element-plus";
import W from "./calculation/index.vue.js";
import H from "./reverse-thrust/index.vue.js";
import { dp as U, e2 as C, e6 as S } from "../../../../../shared/runtime.js";
import { e as $, f as q, h as K, i as Q, a as X } from "../../../../../modules/project-group-welding-config-ee2755b6.js";
import "../../../../../modules/drilling-config-d5ae6cbb.js";
const le = { __name: "index", setup(Y, { expose: b }) {
  const s = f("projectData"), o = a(false), L = a(false), u = a(""), D = a([]), j = i(() => s ? $ : q), M = i(() => s ? K : Q), l = w({ steelClassificationId: null, machinePartType: "" }), n = w({ assembleConfigId: null, steelClassificationId: null, processIdList: null, statisticsMode: null, measurementManner: null, detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] });
  v("saveList", D), v("reverSetFromData", l), v("calculationFormData", n);
  const T = f("headerData"), { radio: I } = T, x = f("parentData"), { tableRef: O } = x, d = a(null), k = i(() => (I.value === 1, "组焊配置")), p = a("40%"), A = [null, W, H], z = i(() => A[I.value]), m = a(null);
  R([() => l, () => n], ([e, t]) => {
    e.id || t.id ? u.value = "修改" : u.value = "创建", n.statisticsMode, p.value = "40%";
  }, { deep: true, immediate: true }), (async () => {
    try {
      const e = await X();
      e.id && (d.value = e.mode);
    } catch (e) {
      console.log(e);
    }
  })();
  const F = async () => {
    try {
      await Promise.all(D.value.map((r) => r()));
      const e = m.value.formData, t = JSON.parse(JSON.stringify(e));
      if (t.processIdList = [t.processIdList], d.value) e.statisticsConfigStatisticsMode = d.value;
      else return C("error", "请先前往统计配置页面配置模式");
      e.id ? (await M.value({ ...t, contractProjectId: s ? s.contractProjectId : null }), C("success", "修改成功")) : (await j.value({ ...t, contractProjectId: s ? s.contractProjectId : null }), C("success", "创建成功")), o.value = false, O.value.getDrillConfigList();
    } catch (e) {
      console.log(e);
    }
  }, V = () => {
    o.value = false, S(l), S(n);
  };
  return b({ visible: o, reverSetFromData: l, currentComponentRef: m, calculationFormData: n }), (e, t) => {
    const r = G, N = J;
    return y(), h(N, { modelValue: o.value, "onUpdate:modelValue": t[1] || (t[1] = (_) => o.value = _), "close-on-click-modal": false, "close-on-press-escape": false, size: p.value, "destroy-on-close": "", "show-close": false, onClosed: V }, { header: c(() => [g(U, { "header-title": k.value, "type-one": false }, null, 8, ["header-title"]), g(r, { plain: "", onClick: t[0] || (t[0] = (_) => o.value = false) }, { default: c(() => t[2] || (t[2] = [P("关闭")])), _: 1, __: [2] }), g(r, { type: "success", onClick: F, loading: L.value }, { default: c(() => [P(B(u.value), 1)]), _: 1 }, 8, ["loading"])]), default: c(() => [(y(), h(E(z.value), { ref_key: "currentComponentRef", ref: m }, null, 512))]), _: 1 }, 8, ["modelValue", "size"]);
  };
} };
export {
  le as default
};
