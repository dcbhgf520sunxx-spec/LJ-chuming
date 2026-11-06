import { e3 as n, i as l, p, dp as i, e5 as m } from "../../../../../../../shared/runtime.js";
import { h as d } from "../../../../../../../modules/subpackage-settle-bdb7b46f.js";
import { cloneDeep as t } from "lodash";
import { inject as f } from "vue";
import { computed as u } from "vue";
import { watchEffect as _ } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as o } from "vue";
const B = { __name: "header", setup(D) {
  const s = t(d), r = f("approveInfo"), a = t(r.value), c = u(() => n(s, a));
  return _(() => {
    if (l(a)) {
      const { applyDate: e } = a;
      a.applyDate = p(e, "{y}-{m}-{d}");
    }
  }), (e, b) => (h(), v("div", null, [o(i, { "header-title": "基本信息" }), o(m, { column: 2, "table-list": c.value }, null, 8, ["table-list"])]));
} };
export {
  B as default
};
