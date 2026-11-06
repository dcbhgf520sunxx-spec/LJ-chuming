import { gt as s } from "../../../../../../shared/runtime.js";
import { ref as a } from "vue";
import { resolveComponent as l } from "vue";
import { openBlock as c } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { unref as o } from "vue";
const u = { __name: "index", setup(m) {
  const t = a(), { crud: e } = s();
  return (_, r) => {
    const n = l("common-drawer");
    return c(), i(n, { ref_key: "drawer_ref", ref: t, "before-close": o(e).cancelDetail, "content-loading": o(e).delAllLoading, "show-close": true, visible: o(e).detailVisible, title: "入库记录", width: "100%" }, { content: d(() => r[0] || (r[0] = [])), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} };
export {
  u as default
};
