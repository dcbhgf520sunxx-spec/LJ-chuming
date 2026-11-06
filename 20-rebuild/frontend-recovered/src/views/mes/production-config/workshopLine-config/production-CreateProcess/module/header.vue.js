import { ref as u } from "vue";
import { computed as V } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { vShow as C } from "vue";
import { createElementVNode as A } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as B } from "vue";
import { Fragment as v } from "vue";
import { m as R, dM as s, B as h, fa as b, es as d } from "../../../../../../shared/runtime.js";
import { _ as k } from "../../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const I = { __name: "header", props: { options: { type: Array, default: () => [] } }, setup(M) {
  const { user: p } = R(["user"]), i = u(), c = { type: s.ARTIFACT.V, artifactType: void 0, mesProductEnum: p.value.mesProductEnum[0] }, { crud: n, query: o } = h(c), f = V(() => o.mesProductEnum === b.BRIDGE.V ? [d.SMALL.V] : []), y = u([s.ARTIFACT, s.ASSEMBLE]);
  return (P, t) => {
    const r = E("common-radio-button");
    return l(), g(v, null, [m(e(k), { modelValue: e(o).mesProductEnum, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).mesProductEnum = a), onChange: e(n).toQuery, ref_key: "mesBridgeEnumRadioRef", ref: i }, null, 8, ["modelValue", "onChange"]), T(A("div", null, [m(r, { modelValue: e(o).type, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).type = a), options: y.value, type: "enum", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(o).type === e(s).ARTIFACT.V ? (l(), _(r, { key: 0, modelValue: e(o).artifactType, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).artifactType = a), options: e(d).ENUM, disabledVal: f.value, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"])) : B("", true)], 512), [[C, e(n).searchToggle]])], 64);
  };
} };
export {
  I as default
};
