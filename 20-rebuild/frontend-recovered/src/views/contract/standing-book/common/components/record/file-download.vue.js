import { u as m, R as u } from "../../../../../../shared/runtime.js";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createBlock as c } from "vue";
import { withCtx as w } from "vue";
import { createVNode as V } from "vue";
import { unref as s } from "vue";
import { isRef as _ } from "vue";
const h = { __name: "file-download", props: { modelValue: { type: Boolean, default: false }, fileList: { type: Array, default: () => [] } }, emits: ["update:modelValue"], setup(t, { emit: a }) {
  const o = t, n = a, { visible: e, handleClose: r } = m({ emit: n, props: o });
  return (b, l) => {
    const i = p("common-drawer");
    return f(), c(i, { modelValue: s(e), "onUpdate:modelValue": l[0] || (l[0] = (d) => _(e) ? e.value = d : null), "before-close": s(r), title: "附件列表", size: "30%" }, { content: w(() => [V(u, { uploadable: false, files: o.fileList, "empty-text": "暂未上传附件", "show-download": "", showView: "" }, null, 8, ["files"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  h as default
};
